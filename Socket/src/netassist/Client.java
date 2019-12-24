/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

/**
 *
 * @author Kowshik
 */
import java.util.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import java.awt.event.*;
public class Client extends Thread
{
ServerSocket ss=null;
ServerSocket mss=null;
Socket sock=null;
Socket msock=null;
Robot robot=null;
Rectangle rect=null;
ScreenShot s;
ServerCommands sc;
public Client()
{
initialize(9996);
}

public void initialize(int port)
{
try{
ss=new ServerSocket(port);
mss=new ServerSocket(9999);
MainGUI.ssReceiver(ss, mss);
}
catch(Exception e){System.out.println("Error");}
this.setPriority(MIN_PRIORITY);
start();
}
public void run()
{
try
{
while(true)
{
sock=ss.accept();
msock=mss.accept();
GraphicsEnvironment genv=GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice gdev=genv.getDefaultScreenDevice();
Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
rect=new Rectangle(dim);
robot=new Robot(gdev);
drawGUI();
s=new ScreenShot(sock,robot,rect);
sc=new ServerCommands(msock,robot);
}
}
catch(IOException ie){}
catch(AWTException ae){}
catch(Exception e){}
}

private void drawGUI()
{
final JFrame frame=new JFrame("Remote System");
JButton button=new JButton("Exit");
frame.setBounds(100,100,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("netassist/k.png")));
        frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            try{
         sock.close();
         msock.close();
         s.stop();
         sc.stop();
         frame.dispose();
         Thread.currentThread().stop();
            }
            catch(Exception ae){}
        }
      });
      frame.setTitle("Assistance from "+sock.getInetAddress().getHostName());
        button.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try{
                sock.close();
                msock.close();
                s.stop();
                sc.stop();
                frame.dispose();
                Thread.currentThread().stop();
                
                }

                catch(Exception ae){}
            }

        }
      );
      frame.setVisible(true);
    }
}

class ScreenShot extends Thread
{
Socket sock=null;
Robot robot=null;
Rectangle rect=null;
ObjectOutputStream oos=null;
public ScreenShot(Socket sock,Robot robot,Rectangle rect)
{
this.sock=sock;
this.robot=robot;
this.rect=rect;
setPriority(MAX_PRIORITY);
try{
oos=new ObjectOutputStream(sock.getOutputStream());
    }
catch(Exception e){}
start();
}
public void run()
{

try
{
oos.writeObject(rect);
}
catch(Exception e)
{}
while(true)
{
BufferedImage image=robot.createScreenCapture(rect);
ImageIcon i=new ImageIcon(image);
try{
oos.writeObject(i);
oos.reset();
this.sleep(100);
}
catch(Exception e)
{Thread.currentThread().stop();}
}
}
}
class ServerCommands extends Thread
{
Socket sock=null;
Robot robot=null;
Scanner scanner=null;
public ServerCommands(Socket sock,Robot robot)
{
this.sock=sock;
this.robot=robot;
setPriority(MIN_PRIORITY);
try{
scanner=new Scanner(sock.getInputStream());
    }
catch(Exception e){}
start();
}
public void run()
{

try{

while(true)
{
int command=scanner.nextInt();
switch(command)
{
case -1:
robot.mousePress(scanner.nextInt());
break;
case -2:
robot.mouseRelease(scanner.nextInt());
break;
case -3:
robot.keyPress(scanner.nextInt());
break;
case -4:
robot.keyRelease(scanner.nextInt());
break;
case -5:
robot.mouseMove(scanner.nextInt(),scanner.nextInt());
break;
}
}
}
catch(Exception e)
{Thread.currentThread().stop();}
}
}

