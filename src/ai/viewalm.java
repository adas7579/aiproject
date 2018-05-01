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
 * @author ULTRON
 */
public class viewalm extends javax.swing.JFrame {

    /**
     * Creates new form viewalm
     */
    DefaultTableModel tm;
    String uid, sync;
    JMake jj = new JMake();
    JSONObject[] tt;
    JSONObject user;

    public viewalm(String ud, String email) {
        initComponents();
        uid = ud;

        this.setLocationRelativeTo(null);
        this.pack();
        tm = (DefaultTableModel) tb.getModel();
        try {
            System.out.println(uid + "   Alarm Debug    " + sync);
            user = jj.getUser(email);
            sync = user.get("sync").toString();
        } catch (Exception ex) {
            Logger.getLogger(viewalm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (sync.equals("1")) {

            try {
                tt = jj.getAlarm(uid);

                for (int i = 0; i < tt.length; i++) {
                    tm.addRow(new Object[]{tt[i].get("alarm_id").toString(), tt[i].get("alarm_time"), tt[i].get("alarm_text")});
                }
                load();
                save();
            } catch (Exception ex) {
                Logger.getLogger(viewalm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            load();
        }

        //tb.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("ENTER"), "none");
//        btsave.setVisible(false);
//        btdel.setVisible(false);
        lbl.setVisible(false);

        //BufferedReader br=new BufferedReader();
        //tm.addRow(new Object[]{"a","b","c"});
//        tb.getModel().addTableModelListener(new TableModelListener() {
//            public void tableChanged(TableModelEvent e) {
//                //System.out.println(e);
//                btsave.setVisible(true);
//                btdel.setVisible(false);
//            }
//        });
//
//        tb.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            public void valueChanged(ListSelectionEvent event) {
//                // do some actions here, for example
//                // print first column value from selected row
//                //System.out.println(tb.getValueAt(table.getSelectedRow(), 0).toString());
//                btsave.setVisible(true);
//                btdel.setVisible(true);
//            }
//        });
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
        lbl = new javax.swing.JLabel();
        btdel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Alarms");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb.setFont(new java.awt.Font("Segoe UI Historic", 0, 15)); // NOI18N
        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alarm ID", "Alarm Time", "Alarm Text"
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
        tb.setColumnSelectionAllowed(true);
        tb.getTableHeader().setReorderingAllowed(false);
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);
        tb.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tb.getColumnModel().getColumnCount() > 0) {
            tb.getColumnModel().getColumn(0).setResizable(false);
            tb.getColumnModel().getColumn(0).setPreferredWidth(2);
            tb.getColumnModel().getColumn(1).setResizable(false);
            tb.getColumnModel().getColumn(1).setPreferredWidth(50);
            tb.getColumnModel().getColumn(2).setResizable(false);
            tb.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 480, 400));

        lbl.setForeground(new java.awt.Color(0, 102, 204));
        lbl.setText("Changes saved");
        getContentPane().add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 20));

        btdel.setText("Delete Alarm");
        btdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdelActionPerformed(evt);
            }
        });
        getContentPane().add(btdel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public static String convH2h(String t) {
//        DateFormat df = new SimpleDateFormat("HH:mm");
//        DateFormat outputformat = new SimpleDateFormat("hh:mm");
//        Date date = null;
//        try {
//            date = df.parse(t);
//        } catch (ParseException ex) {
//            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        if(outputformat.format(date).equals(t))
////            System.out.println("equal");
////        else
////            System.out.println("not equal");
//        return outputformat.format(date);
//    }
    public void load() {
        try {
            DB bb = new DB(uid);
            bb.open();
            ResultSet rs = bb.getData("select * from alarm");
            //tm.setRowCount(0);
            while (rs.next()) {
                int y = 0;
                for (int i = 0; i < tb.getRowCount(); i++) {
                    if (tb.getValueAt(i, 0).toString().equals(rs.getString("alarm_id"))) {
                        y++;
                    }
                }
                if (y != 1) {
                    tm.addRow(new Object[]{(rs.getString("alarm_id")), rs.getString("alarm_time"), rs.getString("alarm_text")});
                    y = 0;
                }
            }
            bb.close();
        } catch (Exception ex) {
        }
    }

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        if (tm.getRowCount() > 0) {
            int a = JOptionPane.showConfirmDialog(null, "Remove this alarm?", "Confirm an action:", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                try {
                    jj.deleteAlarm(new String[]{uid, tb.getValueAt(tb.getSelectedRow(), 0).toString()});
                    tm.removeRow(tb.getSelectedRow());
                    save();
                    //btdel.setVisible(false);
                    load();

                } catch (Exception ex) {
                }
            }
        }
    }//GEN-LAST:event_btdelActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        if (evt.getClickCount() == 2) {
            String aid = tb.getValueAt(tb.getSelectedRow(), 0).toString();
            String h = tb.getValueAt(tb.getSelectedRow(), 1).toString().split(":")[0];
            String m = tb.getValueAt(tb.getSelectedRow(), 1).toString().split(":")[1];
            String tx = tb.getValueAt(tb.getSelectedRow(), 2).toString();

            alarmedit al = new alarmedit(new String[]{uid, aid, h, m, tx}, jj);
            al.setVisible(true);
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
            java.util.logging.Logger.getLogger(viewalm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewalm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewalm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewalm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new viewalm().setVisible(true);
            }
        });
    }

    public void save() {
        try {
            DB bb = new DB(uid);
            bb.open();
            bb.insertData("delete from alarm");

            for (int i = 0; i < tb.getRowCount(); i++) {
                System.out.println("insert into alarm values('" + tm.getValueAt(i, 0).toString() + "','" + tm.getValueAt(i, 1).toString() + "','" + tm.getValueAt(i, 2).toString() + "')");
                bb.insertData("insert into alarm values('" + tm.getValueAt(i, 0).toString() + "','" + tm.getValueAt(i, 1).toString() + "','" + tm.getValueAt(i, 2).toString() + "')");
            }
            bb.close();
            if (sync.equals("1")) {
                for (int i = 0; i < tb.getRowCount(); i++) {
                    jj.deleteAlarm(new String[]{uid, tb.getValueAt(i, 0).toString()});
                }
                for (int i = 0; i < tb.getRowCount(); i++) {
                    jj.InsertAlarm(new String[]{uid, tb.getValueAt(i, 0).toString(), tb.getValueAt(i, 1).toString(), tb.getValueAt(i, 2).toString()});
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
