/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

/**
 *
 * @author Kowshik
 */
import java.net.*;
import javax.swing.*;
import java.io.*;
public class FileThread extends Thread{
ServerSocket ss;
ServerSocket nss;
Socket s1;
Socket s2;
FileThread()
    {
    try{
    ss=new ServerSocket(9998);
    nss=new ServerSocket(9993);
        }
    catch(Exception e){System.exit(0);}
start();
}
public void run()
    {
    try{
    while(true)
    {
        s1=ss.accept();
        s2=nss.accept();
        
        new FileReceiverThread(s1,s2);
    }
        }
    catch(Exception e){JOptionPane.showMessageDialog(null,e);}
}
}
