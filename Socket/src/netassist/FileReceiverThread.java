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
public class FileReceiverThread extends Thread{
    Socket s1,s2;
FileReceiverThread(Socket sock1,Socket sock2)
    {
    s1=sock1;
    s2=sock2;
    this.setPriority(MIN_PRIORITY);
    start();
}
public void run()
    {
    new FileReceiver(s1,s2);
    this.suspend();
    }

}
