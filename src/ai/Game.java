/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import javax.swing.ImageIcon;
import Games.*;
import crypto.*;
import java.awt.Color;
/**
 *
 * @author aNaWorLd
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
        this.setLocationRelativeTo(null);
           this.pack();
//        qz.setIcon(new ImageIcon("assets/game/qz.png"));
//        sn.setIcon(new ImageIcon("assets/game/sn.jpg"));
//        cal.setIcon(new ImageIcon("assets/game/cal.png"));
//        ed.setIcon(new ImageIcon("assets/game/ed.png"));
//         ap.setIcon(new ImageIcon("assets/game/tone.png"));
//          wb.setIcon(new ImageIcon("assets/game/web.png"));
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
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        c1 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();
        c6 = new javax.swing.JLabel();
        c7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Play Games");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 0, 0));
        jButton5.setText("X");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        c1.setBackground(new java.awt.Color(102, 102, 102));
        c1.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        c1.setForeground(new java.awt.Color(255, 255, 255));
        c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1.setText("Snake & Ladder");
        c1.setOpaque(true);
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                c1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c1MouseExited(evt);
            }
        });
        jPanel1.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 350, 60));

        c3.setBackground(new java.awt.Color(102, 102, 102));
        c3.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        c3.setForeground(new java.awt.Color(255, 255, 255));
        c3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c3.setText("Calculator");
        c3.setOpaque(true);
        c3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                c3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c3MouseExited(evt);
            }
        });
        jPanel1.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 350, 60));

        c4.setBackground(new java.awt.Color(102, 102, 102));
        c4.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        c4.setForeground(new java.awt.Color(255, 255, 255));
        c4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c4.setText("Encoder/Decoder");
        c4.setOpaque(true);
        c4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                c4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c4MouseExited(evt);
            }
        });
        jPanel1.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 350, 60));

        c5.setBackground(new java.awt.Color(102, 102, 102));
        c5.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        c5.setForeground(new java.awt.Color(255, 255, 255));
        c5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c5.setText("Web Browser");
        c5.setOpaque(true);
        c5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                c5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c5MouseExited(evt);
            }
        });
        jPanel1.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 350, 60));

        c6.setBackground(new java.awt.Color(102, 102, 102));
        c6.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        c6.setForeground(new java.awt.Color(255, 255, 255));
        c6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c6.setText("Audio Player");
        c6.setOpaque(true);
        c6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                c6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c6MouseExited(evt);
            }
        });
        jPanel1.add(c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 350, 60));

        c7.setBackground(new java.awt.Color(102, 102, 102));
        c7.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        c7.setForeground(new java.awt.Color(255, 255, 255));
        c7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c7.setText("Quiz");
        c7.setOpaque(true);
        c7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                c7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c7MouseExited(evt);
            }
        });
        jPanel1.add(c7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 350, 60));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tools & Games");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseClicked
Snake sk=new Snake();
sk.setVisible(true);
this.setVisible(false);
    
    }//GEN-LAST:event_c1MouseClicked

    private void c1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseEntered
        
            c1.setBackground(ch);
        
    }//GEN-LAST:event_c1MouseEntered
Color ch = new Color(102, 140, 255);
    private void c1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseExited
        
            c1.setBackground(new Color(102, 102, 102));
        
    }//GEN-LAST:event_c1MouseExited

    private void c3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3MouseClicked
calc cc=new calc();
cc.setVisible(true);
this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_c3MouseClicked

    private void c3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3MouseEntered
    c3.setBackground(ch);        // TODO add your handling code here:
    }//GEN-LAST:event_c3MouseEntered

    private void c3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3MouseExited
  c3.setBackground(new Color(102, 102, 102));        // TODO add your handling code here:
    }//GEN-LAST:event_c3MouseExited

    private void c4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c4MouseClicked
Crypto cc=new Crypto();
cc.setVisible(true);
this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_c4MouseClicked

    private void c4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c4MouseEntered
    c4.setBackground(ch);        // TODO add your handling code here:
    }//GEN-LAST:event_c4MouseEntered

    private void c4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c4MouseExited
  c4.setBackground(new Color(102, 102, 102));        // TODO add your handling code here:
    }//GEN-LAST:event_c4MouseExited

    private void c5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c5MouseClicked
Web ww=new Web();
this.setVisible(false);  
ww.main();

    }//GEN-LAST:event_c5MouseClicked

    private void c5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c5MouseEntered
    c5.setBackground(ch);        // TODO add your handling code here:
    }//GEN-LAST:event_c5MouseEntered

    private void c5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c5MouseExited
  c5.setBackground(new Color(102, 102, 102));        // TODO add your handling code here:
    }//GEN-LAST:event_c5MouseExited

    private void c6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c6MouseClicked
AudPlay ad=new AudPlay();
ad.setVisible(true);
this.setVisible(false);
    }//GEN-LAST:event_c6MouseClicked

    private void c6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c6MouseEntered
    c6.setBackground(ch);        // TODO add your handling code here:
    }//GEN-LAST:event_c6MouseEntered

    private void c6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c6MouseExited
  c6.setBackground(new Color(102, 102, 102));        // TODO add your handling code here:
    }//GEN-LAST:event_c6MouseExited

    private void c7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c7MouseClicked
KBC kb=new KBC();
kb.setVisible(true);
this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_c7MouseClicked

    private void c7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c7MouseEntered
    c7.setBackground(ch);        // TODO add your handling code here:
    }//GEN-LAST:event_c7MouseEntered

    private void c7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c7MouseExited
  c7.setBackground(new Color(102, 102, 102));        // TODO add your handling code here:
    }//GEN-LAST:event_c7MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel c7;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
