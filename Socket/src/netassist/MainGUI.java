/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainGUI.java
 *
 * Created on 7 Jan, 2011, 9:54:43 PM
 */

package netassist;

/**
 *
 * @author Kowshik
 */
import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.UIManager.LookAndFeelInfo;
public class MainGUI extends javax.swing.JFrame {
boolean toggle=false;
public static boolean scheduletoggle=false;
static ServerSocket ss,mss;
String iconpath;
Client c;
SchedulerGUI sg;
boolean lookandfeel=false;
    /** Creates new form MainGUI */
    public MainGUI(){
      
        initComponents();
        
        try {
            
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            
            break;
        }
    }
}
        catch (Exception e)
        {
            
           try{
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        initComponents();
           }
           catch(Exception ee){JOptionPane.showMessageDialog(null,"Error in catch2");}}
       
        
        this.setTitle("Network Assistance");
        this.setLocation(360,250);
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("netassist/k.png")));
        sg=new SchedulerGUI();
        try{

        SwingUtilities.updateComponentTreeUI(this);mi1.setVisible(false);
        this.pack();
        }
        catch(Exception e){}
        //JOptionPane.showMessageDialog(null,cmdwhois.getX()+"\n"+cmdwhois.getY());
    }
    public static void ssReceiver(ServerSocket ssock,ServerSocket mssock)
    {
        ss=ssock;
        mss=mssock;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdhelp = new javax.swing.JButton();
        cmdchat = new javax.swing.JButton();
        cmdsendfile = new javax.swing.JButton();
        cmdaskforhelp = new javax.swing.JButton();
        cmdwhois = new javax.swing.JButton();
        cmdscheduler = new javax.swing.JButton();
        mb1 = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        mi1 = new javax.swing.JMenuItem();
        mi2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);

        cmdhelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netassist/h4.gif"))); // NOI18N
        cmdhelp.setText("Assist a Friend");
        cmdhelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdhelpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdhelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdhelpMouseExited(evt);
            }
        });
        cmdhelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdhelpActionPerformed(evt);
            }
        });

        cmdchat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netassist/chat1.png"))); // NOI18N
        cmdchat.setText("Chat");
        cmdchat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdchatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdchatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdchatMouseExited(evt);
            }
        });
        cmdchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdchatActionPerformed(evt);
            }
        });

        cmdsendfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netassist/file1.gif"))); // NOI18N
        cmdsendfile.setText("Send File");
        cmdsendfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdsendfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdsendfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdsendfileMouseExited(evt);
            }
        });
        cmdsendfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsendfileActionPerformed(evt);
            }
        });

        cmdaskforhelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netassist/h6.png"))); // NOI18N
        cmdaskforhelp.setText("Ask for Help");
        cmdaskforhelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdaskforhelpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdaskforhelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdaskforhelpMouseExited(evt);
            }
        });
        cmdaskforhelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaskforhelpActionPerformed(evt);
            }
        });

        cmdwhois.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netassist/whois.png"))); // NOI18N
        cmdwhois.setText("Who is ?");
        cmdwhois.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdwhoisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdwhoisMouseExited(evt);
            }
        });
        cmdwhois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdwhoisActionPerformed(evt);
            }
        });

        cmdscheduler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/netassist/time.png"))); // NOI18N
        cmdscheduler.setText("Scheduler");
        cmdscheduler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdschedulerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdschedulerMouseExited(evt);
            }
        });
        cmdscheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdschedulerActionPerformed(evt);
            }
        });

        menu1.setText("Help");

        mi1.setText("Help Contents");
        mi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi1ActionPerformed(evt);
            }
        });
        menu1.add(mi1);

        mi2.setText("About");
        mi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi2ActionPerformed(evt);
            }
        });
        menu1.add(mi2);

        mb1.add(menu1);

        setJMenuBar(mb1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdsendfile, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdaskforhelp, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdwhois, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdhelp, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdscheduler, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdchat, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmdaskforhelp, cmdchat, cmdhelp, cmdscheduler, cmdsendfile, cmdwhois});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdchat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdhelp, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdaskforhelp, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdscheduler, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(cmdsendfile, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdwhois, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmdaskforhelp, cmdchat, cmdhelp, cmdscheduler, cmdsendfile, cmdwhois});

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdhelpMouseClicked

       
    }//GEN-LAST:event_cmdhelpMouseClicked

    private void cmdchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdchatActionPerformed
        // TODO add your handling code here:
        String ip=JOptionPane.showInputDialog("Enter the IP or Computer name.");
        try
        {
            new ChatThread(new Socket(ip,9997));
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e);}

    }//GEN-LAST:event_cmdchatActionPerformed

    private void cmdchatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdchatMouseClicked
        
    }//GEN-LAST:event_cmdchatMouseClicked

    private void cmdsendfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdsendfileMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_cmdsendfileMouseClicked

    private void cmdaskforhelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdaskforhelpMouseClicked



    }//GEN-LAST:event_cmdaskforhelpMouseClicked

    private void cmdaskforhelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaskforhelpActionPerformed
        // TODO add your handling code here:
        if(toggle==false)
        {
             c=new Client();
            toggle=true;
            cmdaskforhelp.setText("Stop Help ?");
        }
 else
        {
            c.stop();
            try{
            ss.close();
            mss.close();
            }
            catch(Exception e){}
            toggle=false;
            cmdaskforhelp.setText("Ask for Help");
 }
       
    }//GEN-LAST:event_cmdaskforhelpActionPerformed

    private void cmdhelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdhelpActionPerformed
        // TODO add your handling code here:
new Server();
    }//GEN-LAST:event_cmdhelpActionPerformed

    private void cmdsendfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsendfileActionPerformed
        // TODO add your handling code here:
        new FileSenderThread();
      
    }//GEN-LAST:event_cmdsendfileActionPerformed

    private void cmdaskforhelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdaskforhelpMouseEntered
        // TODO add your handling code here:
        
        cmdaskforhelp.setBounds(22,6,170,60);
        
        cmdaskforhelp.setToolTipText("Lets you ask for help that enables others to help you.");
        playSound();
        
    }//GEN-LAST:event_cmdaskforhelpMouseEntered

    private void cmdaskforhelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdaskforhelpMouseExited
        // TODO add your handling code here:
        cmdaskforhelp.setBounds(22,6, 157,49);
        
    }//GEN-LAST:event_cmdaskforhelpMouseExited

    private void cmdhelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdhelpMouseEntered
        // TODO add your handling code here:
        cmdhelp.setBounds(207,6,170,60);
        cmdhelp.setToolTipText("Lets you help a friend through remote assistance.");
        playSound();
        
    }//GEN-LAST:event_cmdhelpMouseEntered

    private void cmdhelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdhelpMouseExited
        // TODO add your handling code here:
        cmdhelp.setBounds(207,6,157,49);
        
    }//GEN-LAST:event_cmdhelpMouseExited

    private void cmdchatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdchatMouseEntered
        // TODO add your handling code here:
        cmdchat.setBounds(394,6,170, 60);
        cmdchat.setToolTipText("Lets you chat with others in the network.");
        playSound();
        
    }//GEN-LAST:event_cmdchatMouseEntered

    private void cmdchatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdchatMouseExited
        // TODO add your handling code here:
        cmdchat.setBounds(394,6,157,49);
        
    }//GEN-LAST:event_cmdchatMouseExited

    private void cmdsendfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdsendfileMouseEntered
        // TODO add your handling code here:
        cmdsendfile.setBounds(22,93,170,60);
        cmdsendfile.setToolTipText("Lets you send a file to others in the network.");
        playSound();
        
    }//GEN-LAST:event_cmdsendfileMouseEntered

    private void cmdsendfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdsendfileMouseExited
        // TODO add your handling code here:
        cmdsendfile.setBounds(22,93,157,49);
        
    }//GEN-LAST:event_cmdsendfileMouseExited

    private void cmdwhoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdwhoisActionPerformed
        // TODO add your handling code here:
       new WhoIs();
        
    }//GEN-LAST:event_cmdwhoisActionPerformed

    private void cmdwhoisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdwhoisMouseEntered
        // TODO add your handling code here:
               cmdwhois.setBounds(207,93,170,60);
                cmdwhois.setToolTipText("Lets you know the details of a particular computer in a network.");
                playSound();
               
    }//GEN-LAST:event_cmdwhoisMouseEntered

    public void playSound()
    {
     final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.asterisk");
 if (runnable != null)
   runnable.run();
    }
    private void cmdwhoisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdwhoisMouseExited
        // TODO add your handling code here:
        cmdwhois.setBounds(207,93,157,49);
        
    }//GEN-LAST:event_cmdwhoisMouseExited

    private void mi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi1ActionPerformed
        // TODO add your handling code here:
        new HelpContents().setVisible(true);
        
    }//GEN-LAST:event_mi1ActionPerformed

    private void mi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi2ActionPerformed
        // TODO add your handling code here:
        new About().setVisible(true);
    }//GEN-LAST:event_mi2ActionPerformed

    private void cmdschedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdschedulerActionPerformed
        // TODO add your handling code here:
        if(scheduletoggle==false)
        {
       sg.setVisible(true);
       scheduletoggle=true;
        }

    }//GEN-LAST:event_cmdschedulerActionPerformed

    private void cmdschedulerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdschedulerMouseEntered
        // TODO add your handling code here:
        cmdscheduler.setBounds(394,93, 170,60);
        cmdscheduler.setToolTipText("Lets you schedule a task.");
        playSound();
    }//GEN-LAST:event_cmdschedulerMouseEntered

    private void cmdschedulerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdschedulerMouseExited
        // TODO add your handling code here:
        cmdscheduler.setBounds(394,93,157,49);
    }//GEN-LAST:event_cmdschedulerMouseExited

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdaskforhelp;
    private javax.swing.JButton cmdchat;
    private javax.swing.JButton cmdhelp;
    private javax.swing.JButton cmdscheduler;
    private javax.swing.JButton cmdsendfile;
    private javax.swing.JButton cmdwhois;
    private javax.swing.JMenuBar mb1;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuItem mi1;
    private javax.swing.JMenuItem mi2;
    // End of variables declaration//GEN-END:variables

}
