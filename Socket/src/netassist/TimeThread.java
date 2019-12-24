/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

import java.util.*;
import javax.swing.*;
public class TimeThread extends Thread{
    int hh,mm,when,ss;
   volatile Calendar c;
    String operation;
    String shutdownCommand;
    String operatingSystem;
TimeThread(int hh,int mm,int when,String op)
    {
    if(hh==12)
    this.hh=0;
    else
    this.hh=hh;
    this.mm=mm;
    this.when=when;
    this.operation=op;
    this.setPriority(Thread.MIN_PRIORITY);
    operatingSystem = System.getProperty("os.name");
    
    start();
}
public void run()
    {
    int hhh,mmm,whenn;
     c=new GregorianCalendar();
hhh=c.get(Calendar.HOUR);
mmm=c.get(Calendar.MINUTE);
whenn = c.get(Calendar.AM_PM);
  while((hh!=c.get(Calendar.HOUR))||(mm!=c.get(Calendar.MINUTE))||(when!=c.get(Calendar.AM_PM)))
  {
       c=new GregorianCalendar();
      System.out.println("Waiting");
        System.out.println(c.get(Calendar.HOUR));
        System.out.println(c.get(Calendar.MINUTE));
  }
if(operation=="Shutdown")
{
   
            try {
                if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
                    
                    shutdownCommand = "shutdown -h now";
                } else if (operatingSystem.startsWith("Win")) {
                
                    shutdownCommand = "shutdown.exe -s -f -t 1";
                }
                Runtime.getRuntime().exec(shutdownCommand);
            } catch (Exception ex) {}


}
if(operation=="Restart")
{
            try {
                if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
                    shutdownCommand = "shutdown -r now";
                } else if (operatingSystem.startsWith("Win")) {
                    shutdownCommand = "shutdown.exe -r -f -t 1";
                }
                Runtime.getRuntime().exec(shutdownCommand);
            } catch (Exception ex) {}


}
    }

}
