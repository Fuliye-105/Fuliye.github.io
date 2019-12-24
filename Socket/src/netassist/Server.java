/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

/**
 *
 * @author Kowshik
 */
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class Server
{
  JFrame frame;

private JPanel cpanel=new JPanel();
ClientHandler c;
Socket client,mclient;
public Server()
    {
    String ip,port;
ip=JOptionPane.showInputDialog("Enter the IP or Computer name");

initialize(ip,9996);
}

public void initialize(String ip,int port)
{
try
{
 client=new Socket(ip,port);
mclient=new Socket(ip,9999);
drawGUI();
c=new ClientHandler(client,mclient,frame,cpanel);
}
catch(IOException ie)
{}
}
public void drawGUI()
{
frame=new JFrame();
frame.add(cpanel);
 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
frame.setVisible(true);
frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("netassist/k.png")));
}
}
class ClientHandler extends Thread
{
final Socket csock;
private final Socket msock;
private JPanel cpanel=new JPanel();
JFrame frame;
ClientCommandsSender ccs;
ClientScreenReceiver csr;
Rectangle clientscreen=null;
ObjectInputStream ois=null;

public ClientHandler(Socket csock1,Socket msock1,JFrame frame1,JPanel cpanel)
{
this.csock=csock1;
this.msock=msock1;
this.cpanel=cpanel;
this.frame=frame1;
setPriority(MIN_PRIORITY);
try{
ois=new ObjectInputStream(csock.getInputStream());
    }
catch(Exception e){}
start();
frame.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            try{
            csock.close();
            msock.close();
            frame.dispose();
            csr.stop();
            Thread.currentThread().stop();
            }
            catch(Exception ee){}
        }
      });
      frame.setTitle("You are assisting "+csock.getInetAddress().getHostName());
}
public void drawGUI()
{
cpanel.setFocusable(true);
}
public void run()
{
drawGUI();
try
{
clientscreen=(Rectangle)ois.readObject();
}
catch(Exception e)
{}
csr=new ClientScreenReceiver(ois,cpanel);
ccs=new ClientCommandsSender(msock,cpanel,clientscreen);
}
}

class ClientScreenReceiver extends Thread
{
private ObjectInputStream ois=null;
private JPanel cpanel=null;
Graphics graphics;
public ClientScreenReceiver(ObjectInputStream ois,JPanel cpanel)
{
this.ois=ois;
this.cpanel=cpanel;
setPriority(MAX_PRIORITY);
graphics=cpanel.getGraphics();
start();
}
public void run()
{
try
{
while(true)
{
ImageIcon imageicon=(ImageIcon)ois.readObject();
Image image=imageicon.getImage();
image=image.getScaledInstance(cpanel.getWidth(),cpanel.getHeight(),Image.SCALE_FAST);
graphics.drawImage(image,0,0,cpanel.getWidth(),cpanel.getHeight(),cpanel);
this.sleep(100);
}
}

catch(Exception e){}
}
}
class ClientCommandsSender implements KeyListener,MouseMotionListener,MouseListener
{
private Socket csock=null;
private JPanel cpanel=null;
private PrintWriter writer=null;
private Rectangle clientscreen=null;
Robot r;
int i=1;
public ClientCommandsSender(Socket sock,JPanel p,Rectangle clientscreen)
{
this.csock=sock;
this.cpanel=p;
this.clientscreen=clientscreen;
cpanel.addKeyListener(this);
cpanel.addMouseListener(this);
cpanel.addMouseMotionListener(this);
try
{
r=new Robot();
writer=new PrintWriter(csock.getOutputStream());
r.keyPress(KeyEvent.VK_TAB);
}
catch(Exception e)
{}
}
 public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        double xScale = clientscreen.getWidth()/cpanel.getWidth();
        System.out.println("xScale: " + xScale);
        double yScale = clientscreen.getHeight()/cpanel.getHeight();
        System.out.println("yScale: " + yScale);
        System.out.println("Mouse Moved");
        writer.println(EnumCommands.MOVE_MOUSE.getAbbrev());
        writer.println((int)(e.getX() * xScale));
        writer.println((int)(e.getY() * yScale));
        writer.flush();
    }


    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
        writer.println(EnumCommands.PRESS_MOUSE.getAbbrev());
        int button = e.getButton();
        int xButton = 16;
        if (button == 3) {
            xButton = 4;
        }
        writer.println(xButton);
        writer.flush();
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
        writer.println(EnumCommands.RELEASE_MOUSE.getAbbrev());
        int button = e.getButton();
        int xButton = 16;
        if (button == 3) {
            xButton = 4;
        }
        writer.println(xButton);
        writer.flush();
    }
    public void mouseEntered(MouseEvent e) {
    }


    public void mouseExited(MouseEvent e) {

    }


    public void keyTyped(KeyEvent e) {
System.out.println("Key Typed ");
    }

    public void keyPressed(KeyEvent e) {

        System.out.println("Key Pressed");
        writer.println(EnumCommands.PRESS_KEY.getAbbrev());
        writer.println(e.getKeyCode());
        writer.flush();
if(i==1)
{
keyReleased(e);
}
    }

    public void keyReleased(KeyEvent e) {
if(i==1)
{
r.keyRelease(KeyEvent.VK_TAB);
System.out.println("Key Released");
writer.println(EnumCommands.RELEASE_KEY.getAbbrev());
writer.println(KeyEvent.VK_TAB);
writer.flush();
i=0;
}
else{
        System.out.println("key Released");
        writer.println(EnumCommands.RELEASE_KEY.getAbbrev());
        writer.println(e.getKeyCode());
        writer.flush();
}
    }
}
enum EnumCommands {
    PRESS_MOUSE(-1),
    RELEASE_MOUSE(-2),
    PRESS_KEY(-3),
    RELEASE_KEY(-4),
    MOVE_MOUSE(-5);

    private int abbrev;

    EnumCommands(int abbrev){
        this.abbrev = abbrev;
    }

    public int getAbbrev(){
        return abbrev;
    }
    }

