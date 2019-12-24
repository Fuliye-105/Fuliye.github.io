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
public class FileSender{
    String ip,filename,filesize,allreceived,accepted;
    long size;
    Socket s1,s2;
    BufferedReader br;
    BufferedWriter bw;
    File f;
    byte[] mybytearray;
    JFileChooser jfc;
    int ch,rch;
    OutputStream os;
    FileInputStream fis;
    BufferedInputStream bis;

FileSender()
    {
    ip=JOptionPane.showInputDialog("Enter the IP or Computer name.");
    try{
    s1=new Socket(ip,9998);
    s2=new Socket(ip,9993);
    br=new BufferedReader(new InputStreamReader(s2.getInputStream()));
    bw=new BufferedWriter(new OutputStreamWriter(s2.getOutputStream()));
    jfc=new JFileChooser();
    ch=jfc.showOpenDialog(jfc);
    if(ch==jfc.OPEN_DIALOG)
    {
        OutputStream os = s1.getOutputStream();
        f=jfc.getSelectedFile();
        filename=f.getName();
        size=f.length();
        filesize=Long.toString(f.length());
        bw.write(filename);
        bw.newLine();
        bw.flush();
        bw.write(filesize);
        bw.newLine();
        bw.flush();
         //accepted=br.readLine();
         //JOptionPane.showMessageDialog(null, accepted);
            mybytearray  = new byte [(int)f.length()];
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
      bis.read(mybytearray,0,mybytearray.length);
      os.write(mybytearray,0,mybytearray.length);
      os.flush();
    //  Thread.currentThread().stop();
     s1.close();
     s2.close();
     bis.close();
     fis.close();
    }
}
    catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        }
        }



