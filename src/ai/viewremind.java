package ai;

import java.io.FileNotFoundException;
import java.io.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONObject;

/**
 *
 * @author ULTRON
 */
public class viewremind extends javax.swing.JFrame {

    /**
     * Creates new form viewremind
     */
    DefaultTableModel tm;
    String uid, sync;
    JMake jj = new JMake();
    JSONObject[] tt;
    JSONObject user;

    public viewremind(String ud, String email) {
        initComponents();
        uid = ud;

        this.setLocationRelativeTo(null);
        this.pack();
        tm = (DefaultTableModel) tb.getModel();
        try {
            user = jj.getUser(email);
            sync = user.get("sync").toString();
        } catch (Exception ex) {
           
        }
        if (sync.equals("1")) {

            try {
                tt = jj.getRem(uid);

                for (int i = 0; i < tt.length; i++) {
                    tm.addRow(new Object[]{tt[i].get("rem_id").toString(), tt[i].get("reminder_date"),tt[i].get("reminder_time"), tt[i].get("reminder_text")});
                }
                load();
                save();
            } catch (Exception ex) {
               load();
            }
        } else {
            load();
        }
        lbl.setVisible(false);

    }

    public void load() {
        try {
            DB bb = new DB(uid);
            bb.open();
            ResultSet rs = bb.getData("select * from reminder");
            //tm.setRowCount(0);
            while (rs.next()) {
                int y = 0;
                for (int i = 0; i < tb.getRowCount(); i++) {
                    if (tb.getValueAt(i, 0).toString().equals(rs.getString("remind_id"))) {
                        y++;
                    }
                }
                if (y != 1) {
                    tm.addRow(new Object[]{(rs.getString("remind_id")), rs.getString("remind_date"), rs.getString("remind_time"), rs.getString("remind_text")});
                    y = 0;
                }
            }
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

        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        btdel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Reminders");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl.setForeground(new java.awt.Color(0, 102, 204));
        lbl.setText("Changes saved");
        getContentPane().add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 344, -1, 20));

        tb.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reminder ID", "Reminder Date", "Reminder Time", "Reminder Text"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb.setColumnSelectionAllowed(true);
        tb.getTableHeader().setReorderingAllowed(false);
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);
        tb.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 392, 327));

        btdel.setText("Delete Reminder");
        btdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdelActionPerformed(evt);
            }
        });
        getContentPane().add(btdel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 420, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        if (evt.getClickCount() == 2) {
            String aid = tb.getValueAt(tb.getSelectedRow(), 0).toString();
            String dd = tb.getValueAt(tb.getSelectedRow(), 1).toString().split("/")[0];
            String mm = tb.getValueAt(tb.getSelectedRow(), 1).toString().split("/")[1];
            String yy = tb.getValueAt(tb.getSelectedRow(), 1).toString().split("/")[2];
            String h = tb.getValueAt(tb.getSelectedRow(), 2).toString().split(":")[0];
            String m = tb.getValueAt(tb.getSelectedRow(), 2).toString().split(":")[1];
            String tx = tb.getValueAt(tb.getSelectedRow(), 3).toString();

            System.out.println("\n\n\n" + aid + " " + dd + " " + mm + " " + yy + " " + h + " " + m + " " + tx + " " + "\n\n\n");

            remindedit al = new remindedit(new String[]{uid, aid, dd, mm, yy, h, m, tx}, jj);
            al.setVisible(true);
        }
    }//GEN-LAST:event_tbMouseClicked

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        if (tm.getRowCount() > 0) {
            int a = JOptionPane.showConfirmDialog(null, "Remove this reminder?", "Confirm an action:", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                try {
                    jj.deleteRem(new String[]{uid, tb.getValueAt(tb.getSelectedRow(), 0).toString()});
                    tm.removeRow(tb.getSelectedRow());
                    save();
                    //btdel.setVisible(false);
                    load();

                } catch (Exception ex) {

                }
            }
        }
    }//GEN-LAST:event_btdelActionPerformed

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
            java.util.logging.Logger.getLogger(viewalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new viewremind().setVisible(true);
            }
        });
    }

    public void save() {
        try {
            DB bb = new DB(uid);
            bb.open();
            bb.insertData("delete from reminder");

            for (int i = 0; i < tb.getRowCount(); i++) {
                System.out.println("insert into reminder values('" + tm.getValueAt(i, 0).toString() + "','" + tm.getValueAt(i, 1).toString() + "','" + tm.getValueAt(i, 2).toString() + "','" + tm.getValueAt(i, 3).toString() + "')");
                bb.insertData("insert into reminder values('" + tm.getValueAt(i, 0).toString() + "','" + tm.getValueAt(i, 1).toString() + "','" + tm.getValueAt(i, 2).toString() + "','" + tm.getValueAt(i, 3).toString() + "')");
            }
            bb.close();
            if (sync.equals("1")) {
                for (int i = 0; i < tb.getRowCount(); i++) {
                    jj.deleteRem(new String[]{uid, tb.getValueAt(i, 0).toString()});
                }
                for (int i = 0; i < tb.getRowCount(); i++) {
                    jj.InsertRem(new String[]{uid, tb.getValueAt(i, 0).toString(), tb.getValueAt(i, 1).toString(), tb.getValueAt(i, 2).toString(), tb.getValueAt(i, 3).toString()});
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        lbl.setVisible(true);
//        load();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    public javax.swing.JTable tb;
    // End of variables declaration//GEN-END:variables
}
