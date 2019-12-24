/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

/**
 *
 * @author Kowshik
 */
import java.io.*;
import java.net.*;
public class WhoIsThread extends Thread{
ServerSocket ss;
Socket s;
BufferedWriter bw;
String osname,osversion,javaversion,osarchitecture,username;
WhoIsThread()
    {
    this.setPriority(MIN_PRIORITY);
    try{
    ss=new ServerSocket(9994);
    start();
        }
    catch(Exception e){System.exit(0);}
}
public void sysDetails()
    {
    try{
    bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
    osname=System.getProperty("os.name");
    osversion=System.getProperty("os.version");
    javaversion=System.getProperty("java.version");
    osarchitecture=System.getProperty("os.arch");
    username=System.getProperty("user.name");
    bw.write(username);
    bw.newLine();
    bw.write(osname);
    bw.newLine();
    bw.write(osversion);
    bw.newLine();
    bw.write(osarchitecture);
    bw.newLine();
    bw.write(javaversion);
    bw.newLine();
    bw.flush();
    bw.close();
    s.close();
        }
    catch(Exception e){}

}
public void run()
    {
    try{
        while(true)
        {
         s=ss.accept();
         sysDetails();

        }
    }
    catch(Exception e){}
}
}
