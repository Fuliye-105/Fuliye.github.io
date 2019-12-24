/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package netassist;

import javax.swing.JOptionPane;

/**
 *
 * @author Kowshik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       new MainGUI().setVisible(true);
       new ChatThread();
      new FileThread();
      new WhoIsThread();
    }

}
