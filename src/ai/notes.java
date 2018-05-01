/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONObject;

/**
 *
 * @author VISION
 */
public class notes extends javax.swing.JFrame {

    /**
     * Creates new form notes
     */
    String uid, sync;
    DefaultTableModel tm;
    JMake jj = new JMake();
    JSONObject[] tt;
    JSONObject user;

    public notes(String uid, String email) {
        initComponents();
        this.uid = uid;
        this.setLocationRelativeTo(null);
        tm = (DefaultTableModel) ntab.getModel();

        try {

            user = jj.getUser(email);
            sync = user.get("sync").toString();
            System.out.println(email + "   Notes Debug    " + sync);
        } catch (Exception ex) {
            Logger.getLogger(viewalm.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(uid);
        if (sync.equals("1")) {
            try {
                tt = jj.getNotes(uid);
                for (int i = 0; i < tt.length; i++) {
                    tm.addRow(new Object[]{tt[i].get("note_id").toString(), tt[i].get("note_date"), tt[i].get("note_data")});
                }
                load();
                save();
            } catch (Exception ex) {
                Logger.getLogger(viewalm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            load();
        }
    }

    public void load() {
        try {
            DB bb = new DB(uid);
            bb.open();
            ResultSet rs = bb.getData("select * from notes");
            while (rs.next()) {
                int y = 0;
                for (int i = 0; i < ntab.getRowCount(); i++) {
                    if (ntab.getValueAt(i, 0).toString().equals(rs.getString("note_id"))) {
                        y++;
                    }
                }
                if (y != 1) {
                    tm.addRow(new Object[]{rs.getString("note_id"), rs.getString("note_date"), rs.getString("note_data")});
                    y = 0;
                }
            }
            //ta.setText(s1);
            bb.close();
        } catch (Exception ex) {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ntab = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Notes");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 30));

        ntab.setFont(new java.awt.Font("Segoe UI Historic", 0, 15)); // NOI18N
        ntab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Note ID", "Note Time", "Note Text"
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
        ntab.setColumnSelectionAllowed(true);
        ntab.getTableHeader().setReorderingAllowed(false);
        ntab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ntabMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ntab);
        ntab.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (ntab.getColumnModel().getColumnCount() > 0) {
            ntab.getColumnModel().getColumn(0).setPreferredWidth(5);
            ntab.getColumnModel().getColumn(1).setPreferredWidth(100);
            ntab.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 480, 370));

        jButton2.setText("Delete Note");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 100, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void save() {
        try {
            DB bb = new DB(uid);
            bb.open();
            bb.insertData("delete from notes");

            for (int i = 0; i < ntab.getRowCount(); i++) {
                System.out.println("insert into notes values('" + tm.getValueAt(i, 0).toString() + "','" + tm.getValueAt(i, 1).toString() + "','" + tm.getValueAt(i, 2).toString() + "')");
                bb.insertData("insert into notes values('" + tm.getValueAt(i, 0).toString() + "','" + tm.getValueAt(i, 1).toString() + "','" + tm.getValueAt(i, 2).toString() + "')");
            }
            bb.close();
            if (sync.equals("1")) {
                for (int i = 0; i < ntab.getRowCount(); i++) {
                    jj.deleteNotes(new String[]{uid, ntab.getValueAt(i, 0).toString()});
                }
                for (int i = 0; i < ntab.getRowCount(); i++) {
                    jj.InsertNotes(new String[]{uid, ntab.getValueAt(i, 0).toString(), ntab.getValueAt(i, 1).toString(), ntab.getValueAt(i, 2).toString()});
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

//        load();
    }
    private void ntabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ntabMouseClicked
        if (evt.getClickCount() == 2) {
            noteedit nt = new noteedit(new String[]{uid, ntab.getValueAt(ntab.getSelectedRow(), 0).toString(), ntab.getValueAt(ntab.getSelectedRow(), 1).toString(), ntab.getValueAt(ntab.getSelectedRow(), 2).toString()}, this);
            nt.setVisible(true);
        }
    }//GEN-LAST:event_ntabMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tm.getRowCount() > 0) {
            int a = JOptionPane.showConfirmDialog(null, "Remove this note?", "Confirm an action:", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                try {
                    jj.deleteNotes(new String[]{uid, ntab.getValueAt(ntab.getSelectedRow(), 0).toString()});
                    tm.removeRow(ntab.getSelectedRow());
                    save();
                    load();

                } catch (Exception ex) {
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new notes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable ntab;
    // End of variables declaration//GEN-END:variables
}
