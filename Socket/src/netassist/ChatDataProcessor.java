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
import java.net.*;
import java.io.*;
public class ChatDataProcessor extends Thread{
    JTextArea txtdisp,txtsend;
    BufferedReader br;
	BufferedWriter bw;
        Socket s;

   public ChatDataProcessor(Socket sock,JTextArea t1,JTextArea t2,JScrollPane jsp1,JScrollPane jsp2,BufferedReader brr,BufferedWriter bww)
    {
    txtdisp=t1;
    txtsend=t2;
    s=sock;
    br=brr;
    bw=bww;
    start();
    }
    public void run()
    {
        while(true)
        {
            try{
            String str=br.readLine();
            if(str.equalsIgnoreCase("ffffexit"))
            {
                JOptionPane.showMessageDialog(null,s.getInetAddress().getHostName()+" is Disconnected !!");
                ChatWindow.cdpthread=true;
                txtsend.setEnabled(false);
                txtdisp.append(s.getInetAddress().getHostName()+" is disconnected !!");
                stop();
            }
            else
            {

            txtdisp.append(str+"\n");
             txtdisp.setCaretPosition(txtdisp.getDocument().getLength());
                }
            }
            catch(Exception e){}
        }

    }
}
