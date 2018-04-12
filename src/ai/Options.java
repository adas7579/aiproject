/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author aNaWorLd
 */
public class Options extends javax.swing.JFrame {

    /**
     * Creates new form Options
     */
    DefaultTableModel tm;
    ArrayList arr = new ArrayList();

    public Options(ArrayList arr) {
        this.arr = arr;

        initComponents();

        this.setLocationRelativeTo(null);
        this.pack();

        tm = (DefaultTableModel) tb.getModel();
try{
        for (int i = 0; i < arr.size(); i++) {
            String a[] = arr.get(i).toString().split("=");
           // if(a[2].contains("."))
            tm.addRow(new Object[]{a[0], a[1], a[2]});
        }
}catch(Exception e){    
        for (int i = 0; i < arr.size(); i++) {
            String a[] = arr.get(i).toString().split("`");
            tm.addRow(new Object[]{a[0], a[1], a[2]});
        }
}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();

        setTitle("Choose....");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb.setRowHeight(20);
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 470, 370));

        desc.setColumns(20);
        desc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        desc.setLineWrap(true);
        desc.setRows(3);
        desc.setWrapStyleWord(true);
        desc.setBorder(null);
        jScrollPane2.setViewportView(desc);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 366, 470, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
desc.setText("");
desc.setText("Name : "+tb.getValueAt(tb.getSelectedRow(), 0).toString());
desc.append("\nType : "+tb.getValueAt(tb.getSelectedRow(), 1).toString());
desc.append("\nLocation : "+tb.getValueAt(tb.getSelectedRow(), 2).toString());
        if (evt.getClickCount() == 2) {

            if (tb.getValueAt(tb.getSelectedRow(), 1).toString().equalsIgnoreCase("website")) {
                try {
                    Desktop.getDesktop().browse(new URI(tb.getValueAt(tb.getSelectedRow(), 2).toString()));
                        this.setVisible(false);
                } catch (Exception ex) {
                }
            } else {
                String e = (String) tb.getValueAt(tb.getSelectedRow(), 2);
                try {
                    System.out.println("Executing: cmd /c start \"\" " + e);
                    Runtime.getRuntime().exec("cmd /c start \"\" " + e);
                    this.setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_tbMouseClicked

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
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new Options().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea desc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tb;
    // End of variables declaration//GEN-END:variables
}
