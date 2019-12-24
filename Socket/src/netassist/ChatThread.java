/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

/**
 *
 * @author Kowshik
 */
import javax.swing.*;
import java.awt.*;
import java.net.*;
public class ChatThread extends Thread{
   ServerSocket ss;
   Socket s;
   ChatThread()
    {
         try{
       ss=new ServerSocket(9997);
       this.setPriority(MIN_PRIORITY);
       start();
        }
       catch(Exception e){JOptionPane.showMessageDialog(null,"NetAssist is already running !");
       System.exit(0);}
   }
   public void run()
    {
       try{
           while(true)
           {
            s=ss.accept();
               new ChatWindow(s);

           }
       }
       catch(Exception e){JOptionPane.showMessageDialog(null, e);}

    }
   ChatThread(Socket sock)
    {
       new ChatWindow(sock);
   }


}
