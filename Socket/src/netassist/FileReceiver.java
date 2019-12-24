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
public class FileReceiver{
 Socket s1,s2;
 BufferedReader br;
 BufferedWriter bw;
 File f;
 String filename,filesize;
int size,ch,rch;
InputStream is;
FileOutputStream fos;
BufferedOutputStream bos;
int current,bytesread;
 FileReceiver(Socket sock1,Socket sock2)
    {
     this.s1=sock1;
     this.s2=sock2;
     try{
     br=new BufferedReader(new InputStreamReader(s2.getInputStream()));
     bw=new BufferedWriter(new OutputStreamWriter(s2.getOutputStream()));
     filename=br.readLine();
     filesize=br.readLine();

     //JOptionPane.showMessageDialog(null, filesize);
     //int ch=JOptionPane.showConfirmDialog(null,"Would like to send a file accept ?","CHoose",0);
        //bw.write("ffffaccept");
       // bw.newLine();
        size=Integer.parseInt(filesize);
        //JOptionPane.showMessageDialog(null,size);
        is=s1.getInputStream();
        byte[] mybytearray  = new byte [size];
        

        fos = new FileOutputStream("D:/"+filename);
        bos = new BufferedOutputStream(fos);
        current=0;
        //bytesread = is.read(mybytearray,0,mybytearray.length);
        //current = bytesread;
        
     do {

       bytesread =
          is.read(mybytearray, current, (mybytearray.length-current));
       if(bytesread >= 0) current =current+ bytesread;
    } while(bytesread!=0);
JOptionPane.showMessageDialog(null,filename+" received.");
    bos.write(mybytearray, 0 , current);
    bos.flush();
    bos.close();
    s1.close();
    s2.close();
     
        }
     catch(Exception e){JOptionPane.showMessageDialog(null,e);}
 }

}
