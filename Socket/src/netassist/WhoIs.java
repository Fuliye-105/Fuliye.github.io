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
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class WhoIs extends Thread{
    String ip,osname,osversion,osarchitecture,username,javaversion;
    Socket s;
    BufferedReader br;
    WhoIs()
    {
     ip=JOptionPane.showInputDialog("Enter the IP or Computer Name.");
     try{
         s=new Socket(ip,9994);
         br=new BufferedReader(new InputStreamReader(s.getInputStream()));
         start();
     }
     catch(Exception e){JOptionPane.showMessageDialog(null,ip+" is not in the network or offline.","Who is ?",JOptionPane.DEFAULT_OPTION);}
    }
   
    public void run()
    {
        try{
        username=br.readLine();
        osname=br.readLine();
        osversion=br.readLine();
        osarchitecture=br.readLine();
        javaversion=br.readLine();
        JOptionPane.showMessageDialog(null,"User Name: "+username+"\n"+"Operating System: "+osname+"\n"+"OS Version: "+osversion
                +"\n"+"OS Architecture: "+osarchitecture+"\n"+"Java Version: "+javaversion,"System Information of "+s.getInetAddress().getHostName(),1);
 
        br.close();
        s.close();
        stop();
        }
        catch(Exception e){}
    }

}
