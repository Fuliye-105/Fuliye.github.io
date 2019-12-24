/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

/**
 *
 * @author Kowshik
 */
public class FileSenderThread extends Thread{
FileSenderThread()
    {
    this.setPriority(MIN_PRIORITY);
    start();
}
public void run()
    {
    new FileSender();
    this.suspend();
    }

}
