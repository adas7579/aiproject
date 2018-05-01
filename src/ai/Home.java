/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.awt.Color;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author aNawOrLd
 */
public class Home extends javax.swing.JFrame {

    JMake json = new JMake();
    splash sh;

    /**
     * Creates new form Home
     */
    public Home() {

        initComponents();
        jLabel3.requestFocus();
        pe.setVisible(false);
        ee.setVisible(false);
        setLocationRelativeTo(null);
        pic.setIcon(new ImageIcon("assets/log.gif"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ee = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chkremem = new javax.swing.JCheckBox();
        pe = new javax.swing.JLabel();
        txtpss = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        forgot = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(153, 51, 0));
        jSeparator1.setOpaque(true);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 330, 7));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("X");
        jButton4.setToolTipText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 50, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("_");
        jButton3.setToolTipText("Minimise");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 50, 30));

        jButton5.setText("Developer Mode");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 150, 30));

        ee.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        ee.setForeground(new java.awt.Color(255, 0, 0));
        ee.setText("* Field Cannot be Blank.");
        getContentPane().add(ee, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, 120, 20));

        jLabel6.setBackground(new java.awt.Color(153, 51, 0));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 30, 10, 690));

        jLabel4.setBackground(new java.awt.Color(153, 51, 0));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 10, 690));

        jLabel3.setBackground(new java.awt.Color(153, 51, 0));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("                Sign In");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 360, -1));

        jLabel1.setBackground(new java.awt.Color(153, 51, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("InArCo : Sign In");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 30));

        chkremem.setBackground(new java.awt.Color(255, 255, 255));
        chkremem.setSelected(true);
        chkremem.setText("Keep Me Logged In");
        getContentPane().add(chkremem, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 140, -1));

        pe.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        pe.setForeground(new java.awt.Color(255, 0, 0));
        pe.setText("* Field Cannot be Blank.");
        getContentPane().add(pe, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 390, 120, 20));

        txtpss.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtpss.setForeground(new java.awt.Color(153, 153, 153));
        txtpss.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpss.setText("Password");
        txtpss.setToolTipText("Password");
        txtpss.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtpss.setEchoChar('\u0000');
        txtpss.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpssFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpssFocusLost(evt);
            }
        });
        txtpss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpssMouseClicked(evt);
            }
        });
        txtpss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpssKeyPressed(evt);
            }
        });
        getContentPane().add(txtpss, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 330, 40));

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 102));
        jButton1.setText("Sign-in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 330, 40));

        forgot.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        forgot.setForeground(new java.awt.Color(255, 153, 0));
        forgot.setText("Forgot Password?");
        forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotMouseExited(evt);
            }
        });
        getContentPane().add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 130, -1));

        txtemail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtemail.setForeground(new java.awt.Color(153, 153, 153));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setText("E-mail");
        txtemail.setToolTipText("E-mail");
        txtemail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtemailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtemailFocusLost(evt);
            }
        });
        txtemail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtemailMouseClicked(evt);
            }
        });
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 330, 40));

        jButton2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 102));
        jButton2.setText("New Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 330, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 2, true));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 390, 390));

        pic.setMaximumSize(new java.awt.Dimension(1366, 720));
        pic.setMinimumSize(new java.awt.Dimension(1366, 720));
        pic.setPreferredSize(new java.awt.Dimension(1366, 720));
        getContentPane().add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1280, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtemailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtemailMouseClicked
        if (txtemail.getText().equalsIgnoreCase("E-mail")) {
            txtemail.setText("");
            txtemail.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtemailMouseClicked

    private void txtpssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpssMouseClicked
        //if(txtpss.getPassword().equals("Password"))
        {
            txtpss.setText("");
            txtpss.setEchoChar('\u25cf');
            txtpss.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtpssMouseClicked

    private void forgotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseEntered
        forgot.setForeground(Color.red);
    }//GEN-LAST:event_forgotMouseEntered

    private void forgotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseExited
        forgot.setForeground(Color.ORANGE);
    }//GEN-LAST:event_forgotMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
       
           
          
        String s = "";
        try {
            Process child = Runtime.getRuntime().exec("wmic csproduct get uuid");

            InputStream in = child.getInputStream();

            int c;
            while ((c = in.read()) != -1) {
                //System.out.print((char) c);
                s = s + (char) c;
            }
            System.out.println(s);
            s = s.substring(4);
            s = s.trim();
            System.out.println(s);
            in.close();

        } catch (Exception ex) {
        }

        if (txtemail.getText().equals("E-mail")) {
            ee.setVisible(true);
            return;
        } else {
            ee.setVisible(false);
        }
        if (txtpss.getText().equals("Password")) {
            pe.setVisible(true);
            return;
        } else {
            pe.setVisible(false);
        }

        try {
            JSONObject i = json.Login(txtemail.getText(), txtpss.getText(), s);

            if (i.containsValue("Passwords Not Matched")) {
                JOptionPane.showMessageDialog(null, "The Password you entered is wrong!");
            } else if (i.containsValue("Email Not Found")) {
                JOptionPane.showMessageDialog(null, "The Email-ID is not Registered!");
            } else if (i.containsValue("Device Not Registered")) {
                String a[] = new String[]{System.getProperty("os.name"), txtemail.getText(), s, System.getProperty("user.name") + "-" + s.substring(14, 18)};
                int res = json.RegDevice(a);
                if (res == 0) {
                    JOptionPane.showMessageDialog(null, "Device Already Binded!", "Warning", 2);
                } else {
                    i = json.Login(txtemail.getText(), txtpss.getText(), s);
                    
                    if (chkremem.isSelected() == true) {
                    remem r = new remem();
                    r.enc(i.get("id").toString(), txtemail.getText(), txtpss.getText(), s);
//                    DB bb = new DB(i.get("id").toString());
//                    bb.open();
//                    bb.newuser(new String[]{txtemail.getText(), txtpss.getText(), s});
//                    bb.close();
                }
                   
              
                    welcome w = new welcome(i);
                    w.pass = txtpss.getText();
                    w.setVisible(true);
                    this.setVisible(false);
                }
            } else {

                if (chkremem.isSelected() == true) {
                    remem r = new remem();
                    r.enc(i.get("id").toString(), txtemail.getText(), txtpss.getText(), s);
//                    DB bb = new DB(i.get("id").toString());
//                    bb.open();
//                    bb.newuser(new String[]{txtemail.getText(), txtpss.getText(), s});
//                    bb.close();
                }
                //    JOptionPane.showMessageDialog(null, "go");
                welcome nn = new welcome(i);
                nn.pass = txtpss.getText();

                nn.setVisible(true);
                this.setVisible(false);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Reg r = new Reg();
        r.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtemailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusGained
        if (txtemail.getText().equals("E-mail")) {
            txtemail.setText("");
            txtemail.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtemailFocusGained

    private void txtemailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtemailFocusLost
        if (txtemail.getText().equals("")) {
            txtemail.setText("E-mail");
            txtemail.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtemailFocusLost

    private void txtpssFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpssFocusGained
        if (txtpss.getText().equals("Password")) {
            txtpss.setEchoChar('\u25cf');
            txtpss.setText("");
             txtemail.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtpssFocusGained

    private void txtpssFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpssFocusLost
        if (txtpss.getText().equals("")) {
            txtpss.setEchoChar('\u0000');
            txtpss.setText("Password");
            txtpss.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtpssFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setState(1);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        txtemail.setText("chilly7579@gmail.com");
        txtpss.setText("1234567");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void forgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotMouseClicked
if (txtemail.getText().equals("E-mail")) {
           JOptionPane.showMessageDialog(null,"Enter Email!");
            return;
        } else {
    try {
     int i=   json.forgetPWD(txtemail.getText());
     if(i==1)
     {
         forget fg=new forget(txtemail.getText());
         fg.setVisible(true);
         this.setVisible(false);
     }
    } catch (Exception ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
    }//GEN-LAST:event_forgotMouseClicked

    private void txtpssKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpssKeyPressed
        if(evt.getKeyChar()==10)
        {
        jButton1.doClick();
        }
    }//GEN-LAST:event_txtpssKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkremem;
    private javax.swing.JLabel ee;
    private javax.swing.JLabel forgot;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel pe;
    private javax.swing.JLabel pic;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtpss;
    // End of variables declaration//GEN-END:variables
}
