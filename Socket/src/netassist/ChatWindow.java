/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

/**
 *
 * @author Kowshik
 */
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.net.*;
import java.io.*;
public class ChatWindow extends JFrame{

    JTextArea txtdisp;
    JTextArea txtsend;
   JScrollPane jsp1,jsp2;
   JButton cmdsend;
   Thread t;
   JPanel panel;
   BufferedReader br;
    BufferedWriter bw;
        Socket s;
        ChatDataProcessor cdp;
        public static boolean cdpthread=false;
    ChatWindow(Socket sock)
    {
     this.s=sock;
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.setLocation(360,250);
     this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("netassist/k.png")));
    txtdisp = new JTextArea();
    txtsend=new JTextArea();
    cmdsend=new JButton("Send");
    setSize(494,355);
    setResizable(false);
    txtdisp.setEditable(false);
    txtdisp.setBounds(5,5,364,223);
    txtsend.setBounds(5,285,364,80);
    jsp1=new JScrollPane(txtdisp);
    jsp2=new JScrollPane(txtsend);
    jsp1.setBounds(5,5,364,223);
    jsp2.setBounds(5,238,364,80);
    cmdsend.setBounds(385,255,81,44);
    panel=new JPanel();
    panel.setLayout(null);
    panel.add(jsp1);
    panel.add(jsp2);
    panel.add(cmdsend);
    add(panel);
    setVisible(true);
    txtsend.requestFocus();
    cmdsend.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String str=txtsend.getText();
        try
        {
            if((str.isEmpty())==false)
            {
                str=s.getLocalAddress().getHostName()+" : "+str;
                bw.write(str);
                bw.newLine();
                bw.flush();
                txtsend.setText("");
                txtdisp.append(str+"\n");
                txtdisp.setCaretPosition(txtdisp.getDocument().getLength());
            }
        }
        catch(Exception ae){JOptionPane.showMessageDialog(null, ae);}
        }
      });
      txtsend.addKeyListener(new KeyListener(){
          public void keyTyped(KeyEvent ke)
          {  
          }

            public void keyPressed(KeyEvent e) {
            String str=txtsend.getText();
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
            {
                if((str.isEmpty())==false)
                try{
                 str=s.getLocalAddress().getHostName()+" : "+str;
               bw.write(str);
                bw.newLine();
                bw.flush();
                txtdisp.append(str+"\n");
                
                txtdisp.setCaretPosition(txtdisp.getDocument().getLength());
                
                }
                catch(Exception ae){}
            }
            }

            public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
            {
                 txtsend.setRows(0);
                txtsend.setSelectionStart(0);
                txtsend.setText("");

            }
            }
      });
    
      addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            try{

          bw.write("ffffexit");
          if(cdpthread==false)
          {
          cdp.stop();
          cdpthread=false;
                }
          bw.close();
          br.close();
          s.close();
          dispose();
          Thread.currentThread().stop();
            }
            catch(Exception ae){}
        }
      });
      setTitle("Chat with "+s.getInetAddress().getHostName());
      try{
     br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(
					s.getOutputStream()));
        }
     catch(Exception e){JOptionPane.showMessageDialog(null, e);}
      cdp=new ChatDataProcessor(s,txtdisp,txtsend,jsp1,jsp2,br,bw);
    }

}
