/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import application.Main;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import javax.swing.JFileChooser;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import mslinks.ShellLink;

/**
 *
 * @author ULTRON
 */
public class welcome extends javax.swing.JFrame {

    ArrayList ar = new ArrayList();
    int fi = 0;
    String bck = "";

    /**
     * Creates new form welcome
     */
    JSONObject js;
    JSONObject dev[];
    JMake jj = new JMake();
    public String pass = "";
    Sync sy;
    int flg = 0, hov = 0;
    DefaultTableModel tb1, tb2, tb3, tb4, tb5, tb6;
    String val = "";
    Color ccd = new Color(255, 51, 51);

    private void RG() {
        z1.setForeground(Color.RED);
        z2.setForeground(Color.GREEN);
        z3.setForeground(Color.BLUE);
        z4.setForeground(Color.RED);
        RGB rr = new RGB(this);
        rr.start();
    }

    public welcome(JSONObject js) {
        this.js = js;
        initComponents();
        RG();
        tb1 = (DefaultTableModel) tdoc.getModel();
        tb2 = (DefaultTableModel) tas.getModel();
        tb3 = (DefaultTableModel) tvs.getModel();
        tb4 = (DefaultTableModel) tmv.getModel();
        tb5 = (DefaultTableModel) tbrw.getModel();
        tb6 = (DefaultTableModel) tapp.getModel();

        this.setLocationRelativeTo(null);
        this.pack();

        hh1.setVisible(false);
        lblun.setText((String) js.get("username").toString().toLowerCase());
        lblemail.setText((String) js.get("email"));
        lblfull.setText((String) js.get("fullname").toString().toUpperCase());
        char ffn = lblfull.getText().charAt(0);
        lblimg.setIcon(new ImageIcon("assets/alpha/" + ffn + ".png"));
        lbldob.setText((String) js.get("dob"));
        lblgen.setText((String) js.get("gender").toString().toUpperCase());
        val = js.get("sync").toString();
        if (val.equals("1")) {
            System.out.println("Sync On");
            synbtn.setSelected(false);
            synbtn.setText("Turn Off");
            synbtn.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        } else {
            synbtn.setSelected(true);
            synbtn.setBorder(BorderFactory.createLineBorder(Color.RED));
            System.out.println("Sync OFF");
            //     synbtn.setRolloverEnabled(true);
        }

        if (js.get("sync").toString().equals("1")) {
        sy = new Sync(js.get("id").toString(), js.get("email").toString());
        sy.start();
        }
        getdev();

        ubtn.setIcon(new ImageIcon("assets/edit.png"));
        fbtn.setIcon(new ImageIcon("assets/edit.png"));
        dbtn.setIcon(new ImageIcon("assets/edit.png"));
        gbtn.setIcon(new ImageIcon("assets/edit.png"));
        btrefresh.setIcon(new ImageIcon("assets/refresh.png"));
        lblwel.setBackground(ch);
        fav.setVisible(false);
        sync.setVisible(false);
        pnlacc.setVisible(false);
        ss.setVisible(false);
        about.setVisible(false);
        uun.setText(lblun.getText().toLowerCase());

   
        getConfig();
        getFav();
          
//        fname = "AI.lnk";
//        file("C:\\Users\\aNaWorLd\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup");
    }
private void qrc()
{
RSA rs=new RSA();
        try {
         
            String bar=js.get("email").toString()+":"+rs.Encode(pass, 5,221);
           
            QRCode qq=new QRCode();
            try {
                qq.createCode(bar);
            } catch (WriterException ex) {
             
            } catch (NotFoundException ex) {
               
            }
        } catch (IOException ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
        qr.setIcon(new ImageIcon("assets/qr.png"));
}
    public welcome(JSONObject js, Sync sy) {
        this.js = js;
        initComponents();
        RG();
        this.sy = sy;
        tb1 = (DefaultTableModel) tdoc.getModel();
        tb2 = (DefaultTableModel) tas.getModel();
        tb3 = (DefaultTableModel) tvs.getModel();
        tb4 = (DefaultTableModel) tmv.getModel();
        tb5 = (DefaultTableModel) tbrw.getModel();
        tb6 = (DefaultTableModel) tapp.getModel();

        this.setLocationRelativeTo(null);
        this.pack();

        hh1.setVisible(false);
        lblun.setText((String) js.get("username"));
        lblemail.setText((String) js.get("email"));
        lblfull.setText((String) js.get("fullname").toString().toUpperCase());
        char ffn = lblfull.getText().charAt(0);
        lblimg.setIcon(new ImageIcon("assets/alpha/" + ffn + ".png"));
        lbldob.setText((String) js.get("dob"));
        lblgen.setText((String) js.get("gender").toString().toUpperCase());
        val = js.get("sync").toString();
        if (val.equals("1")) {
            System.out.println("Sync On");
            synbtn.setSelected(false);
            synbtn.setText("Turn Off");
            synbtn.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        } else {
            synbtn.setSelected(true);
            synbtn.setBorder(BorderFactory.createLineBorder(Color.RED));
            System.out.println("Sync OFF");
            //     synbtn.setRolloverEnabled(true);
        }

//        if (js.get("sync").toString().equals("1")) {            
//            this.sy.start();
//        }
        getdev();

        ubtn.setIcon(new ImageIcon("assets/edit.png"));
        fbtn.setIcon(new ImageIcon("assets/edit.png"));
        dbtn.setIcon(new ImageIcon("assets/edit.png"));
        gbtn.setIcon(new ImageIcon("assets/edit.png"));
        btrefresh.setIcon(new ImageIcon("assets/refresh.png"));
        lblwel.setBackground(ch);
        fav.setVisible(false);
        sync.setVisible(false);
        pnlacc.setVisible(false);
        ss.setVisible(false);
        uun.setText(lblun.getText().toLowerCase());

        getConfig();
        getFav();
//        fname = "AI.lnk";
//        file("C:\\Users\\aNaWorLd\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hh1 = new javax.swing.JPanel();
        tts = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        chktts = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        pnltts = new javax.swing.JPanel();
        vname = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        freq = new javax.swing.JSlider();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        set = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        sww = new javax.swing.JCheckBox();
        qr = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        pnlacc = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblimg = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblfull = new javax.swing.JTextField();
        lblun = new javax.swing.JTextField();
        lblgen = new javax.swing.JTextField();
        lbldob = new javax.swing.JTextField();
        gbtn = new javax.swing.JButton();
        ss = new javax.swing.JButton();
        ubtn = new javax.swing.JButton();
        fbtn = new javax.swing.JButton();
        combgen = new javax.swing.JComboBox<>();
        dbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        sync = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        synbtn = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        devcom = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        devs = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        devn = new javax.swing.JLabel();
        devt = new javax.swing.JLabel();
        devi = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btrefresh = new javax.swing.JButton();
        fav = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdoc = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tas = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tvs = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tmv = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbrw = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tapp = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        about = new javax.swing.JPanel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        hh = new javax.swing.JPanel();
        jSeparator9 = new javax.swing.JSeparator();
        uun = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        z1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        z2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        z3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        z4 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblacc = new javax.swing.JLabel();
        lblset = new javax.swing.JLabel();
        lblcng = new javax.swing.JLabel();
        lbllog = new javax.swing.JLabel();
        lblwel = new javax.swing.JLabel();
        lblsyn = new javax.swing.JLabel();
        lbltts = new javax.swing.JLabel();
        lblabout = new javax.swing.JLabel();
        lblfav = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Inarco - Home");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hh1.setBackground(new java.awt.Color(51, 51, 51));
        hh1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tts.setBackground(new java.awt.Color(51, 51, 51));
        tts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tts.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 470, 10));

        chktts.setFont(new java.awt.Font("Segoe UI Historic", 0, 15)); // NOI18N
        chktts.setForeground(new java.awt.Color(255, 255, 255));
        chktts.setSelected(true);
        chktts.setText("Enable Text-to-Speech");
        chktts.setOpaque(false);
        chktts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkttsItemStateChanged(evt);
            }
        });
        chktts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkttsMouseClicked(evt);
            }
        });
        tts.add(chktts, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Text-to-Speech ");
        tts.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        pnltts.setBackground(new java.awt.Color(51, 51, 51));
        pnltts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnltts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female 1", "Female 2" }));
        pnltts.add(vname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 220, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Set Frequency :");
        pnltts.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, 30));

        freq.setBackground(new java.awt.Color(255, 255, 255));
        freq.setMajorTickSpacing(1);
        freq.setMaximum(10);
        freq.setPaintLabels(true);
        freq.setValue(1);
        freq.setOpaque(false);
        freq.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                freqStateChanged(evt);
            }
        });
        pnltts.add(freq, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 220, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Select Voice :");
        pnltts.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 130, 30));

        jButton5.setText("Test");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pnltts.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 70, -1));

        tts.add(pnltts, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 440, 260));

        hh1.add(tts, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 530, 400));

        set.setBackground(new java.awt.Color(51, 51, 51));
        set.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        set.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        set.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 470, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Settings :");
        set.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        sww.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        sww.setForeground(new java.awt.Color(255, 255, 255));
        sww.setText("Start with Windows");
        sww.setOpaque(false);
        sww.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                swwMouseClicked(evt);
            }
        });
        sww.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swwActionPerformed(evt);
            }
        });
        set.add(sww, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        set.add(qr, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 310, 210));

        jButton3.setText("Clear History");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        set.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        hh1.add(set, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 530, 400));

        pnlacc.setBackground(new java.awt.Color(51, 51, 51));
        pnlacc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnlacc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("My Account :");
        pnlacc.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        pnlacc.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 470, 10));
        pnlacc.add(lblimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 110));

        lblemail.setFont(new java.awt.Font("Segoe UI Historic", 0, 15)); // NOI18N
        lblemail.setForeground(new java.awt.Color(255, 255, 255));
        lblemail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblemail.setText("myemail@gmail.com");
        pnlacc.add(lblemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 290, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("USERNAME :");
        pnlacc.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("FULLNAME :");
        pnlacc.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("DOB :");
        pnlacc.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("GENDER :");
        pnlacc.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));
        pnlacc.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -20, -1, -1));

        lblfull.setEditable(false);
        lblfull.setBackground(new java.awt.Color(51, 51, 51));
        lblfull.setFont(new java.awt.Font("Segoe UI Historic", 0, 15)); // NOI18N
        lblfull.setForeground(new java.awt.Color(255, 255, 255));
        lblfull.setText("@>anadi");
        pnlacc.add(lblfull, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 190, 30));

        lblun.setEditable(false);
        lblun.setBackground(new java.awt.Color(51, 51, 51));
        lblun.setFont(new java.awt.Font("Segoe UI Historic", 0, 15)); // NOI18N
        lblun.setForeground(new java.awt.Color(255, 255, 255));
        lblun.setText("@>anadi");
        pnlacc.add(lblun, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 190, 30));

        lblgen.setBackground(new java.awt.Color(51, 51, 51));
        lblgen.setFont(new java.awt.Font("Segoe UI Historic", 0, 15)); // NOI18N
        lblgen.setForeground(new java.awt.Color(255, 255, 255));
        lblgen.setText("Male");
        pnlacc.add(lblgen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        lbldob.setEditable(false);
        lbldob.setBackground(new java.awt.Color(51, 51, 51));
        lbldob.setFont(new java.awt.Font("Segoe UI Historic", 0, 15)); // NOI18N
        lbldob.setForeground(new java.awt.Color(255, 255, 255));
        lbldob.setText("12/12/1999");
        pnlacc.add(lbldob, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        gbtn.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        gbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gbtnActionPerformed(evt);
            }
        });
        pnlacc.add(gbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 30, 30));

        ss.setText("Save");
        ss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssActionPerformed(evt);
            }
        });
        pnlacc.add(ss, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 70, 30));

        ubtn.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        ubtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubtnActionPerformed(evt);
            }
        });
        pnlacc.add(ubtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 30, 30));

        fbtn.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        fbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbtnActionPerformed(evt);
            }
        });
        pnlacc.add(fbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 30, 30));

        combgen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        pnlacc.add(combgen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));
        combgen.setVisible(false);

        dbtn.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        dbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbtnActionPerformed(evt);
            }
        });
        pnlacc.add(dbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 30, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlacc.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 130, 30));

        hh1.add(pnlacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 530, 400));

        sync.setBackground(new java.awt.Color(51, 51, 51));
        sync.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        sync.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sync.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 490, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sync");
        sync.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        synbtn.setSelected(true);
        synbtn.setText("Turn ON");
        synbtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                synbtnItemStateChanged(evt);
            }
        });
        synbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                synbtnActionPerformed(evt);
            }
        });
        sync.add(synbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 100, 30));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Devices");
        jLabel5.setToolTipText("");
        sync.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, 30));

        devcom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                devcomItemStateChanged(evt);
            }
        });
        sync.add(devcom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 240, 30));
        sync.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 480, 20));
        sync.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 350, 10));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Status :");
        sync.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 90, 20));

        devs.setForeground(new java.awt.Color(0, 255, 51));
        devs.setText("Connected");
        sync.add(devs, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 240, 20));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("System Type :");
        sync.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 90, 20));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Device ID :");
        sync.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 90, 20));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Device Name :");
        sync.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 90, 20));

        devn.setForeground(new java.awt.Color(255, 255, 51));
        devn.setText("Device Name :");
        sync.add(devn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 270, 20));

        devt.setForeground(new java.awt.Color(255, 255, 51));
        devt.setText("Device Name :");
        sync.add(devt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 270, 20));

        devi.setForeground(new java.awt.Color(255, 255, 51));
        devi.setText("Device Name :");
        sync.add(devi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 290, 20));

        jButton4.setText("Remove Device");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        sync.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 150, 30));

        btrefresh.setBackground(new java.awt.Color(255, 255, 255));
        btrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrefreshActionPerformed(evt);
            }
        });
        sync.add(btrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 30, 30));

        hh1.add(sync, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 530, 400));

        fav.setBackground(new java.awt.Color(51, 51, 51));
        fav.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        fav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        fav.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 470, 10));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Favourites :");
        fav.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdoc.setBackground(new java.awt.Color(204, 204, 204));
        tdoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folder Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tdoc.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(tdoc);
        tdoc.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 450, 240));

        jButton7.setText("Remove");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, 30));

        jButton8.setText("Add New");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 30));

        jTabbedPane1.addTab("Documents", jPanel1);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folder Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tas);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 450, 240));

        jButton9.setText("Add New");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 30));

        jButton10.setText("Remove");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, 30));

        jTabbedPane1.addTab("Audio Songs", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tvs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folder Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tvs);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 450, 240));

        jButton11.setText("Add New");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 30));

        jButton12.setText("Remove");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, 30));

        jTabbedPane1.addTab("Video Songs", jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tmv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folder Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tmv);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 450, 240));

        jButton13.setText("Add New");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 30));

        jButton14.setText("Remove");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, 30));

        jTabbedPane1.addTab("Movies", jPanel6);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbrw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Page Name", "URL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbrw);

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 450, 240));

        jButton15.setText("Add New");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 30));

        jButton16.setText("Remove");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, 30));

        jTabbedPane1.addTab("Browsing", jPanel7);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tapp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folder Name", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tapp);

        jPanel9.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 450, 240));

        jButton17.setText("Add New");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 30));

        jButton18.setText("Remove");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, 30));

        jTabbedPane1.addTab("Applications", jPanel9);

        fav.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 310));

        hh1.add(fav, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 530, 400));

        about.setBackground(new java.awt.Color(51, 51, 51));
        about.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        about.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        about.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 470, 10));

        jLabel26.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("<html>The <b>InArCo Developer Team</b> is an enthusiast group of students who work with the motive of learning from each and every bit of available opportunities and finding new ways to implement that knowledge into the ongoing project. This team has a simple rule -<br>   <b>Think >  Implement >  Succeed >  Repeat</b><br> while also watching out for possible failures in the ideas.<br><br>The Team has developed this Project with full motivation to ease the use of <b>Computers and Mobiles</b> and also to get more and more amount of information from them.</html>");
        about.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 450, 280));

        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("About us");
        about.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        hh1.add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 530, 400));

        getContentPane().add(hh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 640, 490));

        hh.setBackground(new java.awt.Color(0, 0, 0));
        hh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        hh.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 20, 360));

        uun.setFont(new java.awt.Font("Monotype Corsiva", 3, 48)); // NOI18N
        uun.setForeground(new java.awt.Color(102, 140, 255));
        uun.setText("Welcome!");
        hh.add(uun, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 380, 70));

        jLabel11.setFont(new java.awt.Font("Monotype Corsiva", 3, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Welcome!");
        hh.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, 70));

        jSeparator6.setBackground(new java.awt.Color(102, 140, 255));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        hh.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 490));

        z1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        z1.setForeground(new java.awt.Color(255, 255, 255));
        z1.setText("get Assistance");
        hh.add(z1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 240, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("<html>InArCo is a software agent that performs tasks and services for an individual, like opening apps, recent items,<br> favourite files and folders, creating alarm, reminders, notes, perform arithmetic calculations besides helping you answering your queries from around the world.</html>");
        hh.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, 130));

        z2.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        z2.setForeground(new java.awt.Color(255, 255, 255));
        z2.setText("power Of Artificial Intelligence");
        hh.add(z2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 330, 40));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("<html>InArCo binds with powerful Artificial Intelligence program which with the ability of Natural Language Processing which gives very fast and user customised results of user's query.</html>");
        hh.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 270, 90));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("<html>InArCo provides you seamless syncing with other cross platform application support with support on  Android and Windows and upcoming on Linux and macOS.  </html>");
        hh.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 240, 100));

        z3.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        z3.setForeground(new java.awt.Color(255, 255, 255));
        z3.setText("cross-Platform Support");
        hh.add(z3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 250, 40));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("<html>Bind your Android device with smart wearables to provide you with syncronised notifications access without even having to look at your mobile device.</html>");
        hh.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 280, 100));

        z4.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        z4.setForeground(new java.awt.Color(255, 255, 255));
        z4.setText("specialised Hardware");
        hh.add(z4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 260, 40));
        hh.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 590, 10));
        hh.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 580, 10));

        getContentPane().add(hh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 640, 490));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblacc.setBackground(new java.awt.Color(102, 102, 102));
        lblacc.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lblacc.setForeground(new java.awt.Color(255, 255, 255));
        lblacc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblacc.setText("My Account");
        lblacc.setOpaque(true);
        lblacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblaccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblaccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblaccMouseExited(evt);
            }
        });
        jPanel2.add(lblacc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 190, 40));

        lblset.setBackground(new java.awt.Color(102, 102, 102));
        lblset.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lblset.setForeground(new java.awt.Color(255, 255, 255));
        lblset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblset.setText("Settings");
        lblset.setOpaque(true);
        lblset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblsetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblsetMouseExited(evt);
            }
        });
        jPanel2.add(lblset, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 40));

        lblcng.setBackground(new java.awt.Color(102, 102, 102));
        lblcng.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lblcng.setForeground(new java.awt.Color(255, 255, 255));
        lblcng.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcng.setText("Change Log");
        lblcng.setOpaque(true);
        lblcng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcngMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcngMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcngMouseExited(evt);
            }
        });
        jPanel2.add(lblcng, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 190, 40));

        lbllog.setBackground(new java.awt.Color(102, 102, 102));
        lbllog.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lbllog.setForeground(new java.awt.Color(255, 255, 255));
        lbllog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllog.setText("Log-out");
        lbllog.setOpaque(true);
        lbllog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbllogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbllogMouseExited(evt);
            }
        });
        jPanel2.add(lbllog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 190, 34));

        lblwel.setBackground(new java.awt.Color(102, 102, 102));
        lblwel.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lblwel.setForeground(new java.awt.Color(255, 255, 255));
        lblwel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblwel.setText("Welcome");
        lblwel.setOpaque(true);
        lblwel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblwelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblwelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblwelMouseExited(evt);
            }
        });
        jPanel2.add(lblwel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 190, 40));

        lblsyn.setBackground(new java.awt.Color(102, 102, 102));
        lblsyn.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lblsyn.setForeground(new java.awt.Color(255, 255, 255));
        lblsyn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblsyn.setText("Sync");
        lblsyn.setOpaque(true);
        lblsyn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsynMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblsynMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblsynMouseExited(evt);
            }
        });
        jPanel2.add(lblsyn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 190, 40));

        lbltts.setBackground(new java.awt.Color(102, 102, 102));
        lbltts.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lbltts.setForeground(new java.awt.Color(255, 255, 255));
        lbltts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltts.setText("Text-to-Speech");
        lbltts.setOpaque(true);
        lbltts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblttsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblttsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblttsMouseExited(evt);
            }
        });
        jPanel2.add(lbltts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 190, 40));

        lblabout.setBackground(new java.awt.Color(102, 102, 102));
        lblabout.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lblabout.setForeground(new java.awt.Color(255, 255, 255));
        lblabout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblabout.setText("About us");
        lblabout.setOpaque(true);
        lblabout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblaboutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblaboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblaboutMouseExited(evt);
            }
        });
        jPanel2.add(lblabout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 190, 40));

        lblfav.setBackground(new java.awt.Color(102, 102, 102));
        lblfav.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        lblfav.setForeground(new java.awt.Color(255, 255, 255));
        lblfav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfav.setText("Favourites");
        lblfav.setOpaque(true);
        lblfav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblfavMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblfavMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblfavMouseExited(evt);
            }
        });
        jPanel2.add(lblfav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 490));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 0, 255));
        jButton2.setText("Start >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 830, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents
Color ch = new Color(102, 140, 255);
    private void lblsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsetMouseClicked
        off();
        lblset.setBackground(ch);
        set.setVisible(true);
        qrc();
    }//GEN-LAST:event_lblsetMouseClicked

    private void lblsetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsetMouseEntered
        if (lblset.getBackground() != ch) {
            lblset.setBackground(Color.darkGray);
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblsetMouseEntered

    private void lblsetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsetMouseExited
        // JOptionPane.showMessageDialog(null,lblset.getBackground());
        if (lblset.getBackground() != ch) {
            lblset.setBackground(new Color(102, 102, 102));
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblsetMouseExited

    private void lblaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccMouseClicked
        off();
        lblacc.setBackground(ch);

        pnlacc.setVisible(true);
    }//GEN-LAST:event_lblaccMouseClicked

    private void lblaccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccMouseEntered
        if (lblacc.getBackground() != ch) {
            lblacc.setBackground(Color.darkGray);
        }
    }//GEN-LAST:event_lblaccMouseEntered

    private void lblaccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccMouseExited
        if (lblacc.getBackground() != ch) {
            lblacc.setBackground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_lblaccMouseExited

    private void lblcngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcngMouseClicked
        lblcng.setBackground(ch);

        try {
            FileReader fr = new FileReader("assets/changelog.txt");
            BufferedReader br = new BufferedReader(fr);
            String s, s1 = "";
            while ((s = br.readLine()) != null) {
                s1 += s + "\n";
            }
            br.close();
            fr.close();
            Change ch = new Change(s1);
            ch.setVisible(true);
            //JOptionPane.showMessageDialog(null, s1);
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_lblcngMouseClicked

    private void lblcngMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcngMouseEntered
        lblcng.setBackground(Color.darkGray);
    }//GEN-LAST:event_lblcngMouseEntered

    private void lblcngMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcngMouseExited
        lblcng.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lblcngMouseExited

    private void lbllogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogMouseClicked
        String s = "";
        try {
            Process child = Runtime.getRuntime().exec("wmic csproduct get uuid");

            InputStream in = child.getInputStream();

            int c;
            while ((c = in.read()) != -1) {
                //System.out.print((char) c);
                s = s + (char) c;
            }

            s = s.substring(4);
            s = s.trim();

            in.close();

        } catch (Exception ex) {
        }

        //off();
        lbllog.setBackground(ch);
        int a = JOptionPane.showConfirmDialog(this, "Are you sure want to logout?");

        if (a == 0) {

            try {

                JSONObject tt = jj.Logout(js.get("id").toString(), s);
                // JOptionPane.showMessageDialog(null, ""+tt);
                if (tt.containsValue("Successfully Logged Out")) {
                    remem r = new remem();
                    r.clear(js.get("id").toString());
                    System.exit(0);
                }
            } catch (Exception ex) {
                Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lbllogMouseClicked

    private void lbllogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogMouseEntered
        lbllog.setBackground(Color.darkGray);
    }//GEN-LAST:event_lbllogMouseEntered

    private void lbllogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogMouseExited
        lbllog.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_lbllogMouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setConfig();
        this.setVisible(false);
        //int y = Integer.parseInt(ar.get(1).toString().split("=")[1]);
        test t = new test(js.get("id").toString(), ar, js.get("email").toString(), sy, hov);
        t.detail = js;
        t.pass = pass;

        t.uid = js.get("id").toString();

        t.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblwelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblwelMouseClicked

        hh.setVisible(true);
        hh1.setVisible(false);
        lblwel.setBackground(ch);
        off1();
    }//GEN-LAST:event_lblwelMouseClicked

    private void lblwelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblwelMouseEntered
        if (lblwel.getBackground() != ch) {
            lblwel.setBackground(Color.darkGray);
        }
    }//GEN-LAST:event_lblwelMouseEntered

    private void lblwelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblwelMouseExited
        if (lblwel.getBackground() != ch) {
            lblwel.setBackground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_lblwelMouseExited

    private void lblsynMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsynMouseClicked
        off();
        lblsyn.setBackground(ch);
        sync.setVisible(true);
    }//GEN-LAST:event_lblsynMouseClicked

    private void lblsynMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsynMouseEntered
        if (lblsyn.getBackground() != ch) {
            lblsyn.setBackground(Color.darkGray);
        }
    }//GEN-LAST:event_lblsynMouseEntered

    private void lblsynMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsynMouseExited
        if (lblsyn.getBackground() != ch) {
            lblsyn.setBackground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_lblsynMouseExited

    private void gbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gbtnActionPerformed
        fi = 4;
        bck = lblgen.getText();
        combgen.setVisible(true);
        lblgen.setVisible(false);
        ss.setVisible(true);
    }//GEN-LAST:event_gbtnActionPerformed
    Color cc = new Color(51, 51, 51);
    private void ssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssActionPerformed
        switch (fi) {
            case 1:
                if (lblun.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Field Can't be left Blank!", "Attention!", 1);
                    return;
                }
                lblun.setText(lblun.getText().toUpperCase());
                break;
            case 2:
                if (lblfull.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Field Can't be left Blank!", "Attention!", 1);
                    return;
                }

                break;

        }

        lblun.setEditable(false);
        lblun.setForeground(Color.WHITE);
        lblun.setBackground(cc);

        lblfull.setEditable(false);
        lblfull.setForeground(Color.WHITE);
        lblfull.setBackground(cc);

        lblgen.setVisible(true);
        lblgen.setText(combgen.getSelectedItem() + "");
        combgen.setVisible(false);

        String po = lblun.getText().toUpperCase();
        String data[] = new String[]{js.get("id").toString(), po, lblfull.getText(), lbldob.getText(), lblgen.getText(), lblemail.getText()};

        try {
            int i = jj.UpdateDetails(data);
            if (i == 1) {
                JOptionPane.showMessageDialog(this, "Details Updated Successfully");
                char ffn = lblfull.getText().charAt(0);
                lblimg.setIcon(new ImageIcon("assets/alpha/" + ffn + ".png"));
            } else {
                JOptionPane.showMessageDialog(this, "Failed To Update!");
                lblun.setText(data[1]);
                lblfull.setText(data[2]);
                lbldob.setText(data[3]);
                lblgen.setText(data[4]);
            }
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }

        ss.setVisible(false);
    }//GEN-LAST:event_ssActionPerformed

    private void ubtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubtnActionPerformed
        fi = 1;
        bck = lblun.getText().toUpperCase();
        lblun.setEditable(true);
        lblun.setBackground(Color.WHITE);
        lblun.setForeground(Color.BLACK);
        ss.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_ubtnActionPerformed

    private void fbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbtnActionPerformed
        fi = 2;
        bck = lblfull.getText();
        lblfull.setEditable(true);
        lblfull.setBackground(Color.WHITE);
        lblfull.setForeground(Color.BLACK);
        ss.setVisible(true);
    }//GEN-LAST:event_fbtnActionPerformed

    private void dbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbtnActionPerformed
        fi = 3;
        bck = lbldob.getText();
        DD d = new DD(this);
        d.setVisible(true);
        ss.setVisible(true);
    }//GEN-LAST:event_dbtnActionPerformed

    private void synbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_synbtnActionPerformed
        if (synbtn.getText().equals("Turn ON")) {
            try {
                int res = jj.sync(new String[]{js.get("id").toString(), "1"});
                if (res == 1) {
                    sy = new Sync(js.get("id").toString(), js.get("email").toString());
                    sy.start();
                    synbtn.setText("Turn OFF");
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to Turn Off Sync!");
                }
            } catch (Exception ex) {
                Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                int res = jj.sync(new String[]{js.get("id").toString(), "0"});
                if (res == 1) {
                    sy.stop();
                    synbtn.setText("Turn ON");
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to Turn On Sync!");
                }
            } catch (Exception ex) {
                Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_synbtnActionPerformed

    private void devcomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_devcomItemStateChanged

        String a = (String) devcom.getSelectedItem();

        for (int i = 0; i < dev.length; i++) {
            if (dev[i].get("device_name").toString().equals(a)) {
                // System.out.println(dev[i].get("device_name").toString() + ">>>>>>>>" + a);

                devn.setText(dev[i].get("device_name").toString());
                devt.setText(dev[i].get("type").toString());
                devi.setText(dev[i].get("device_id").toString());
                if (dev[i].get("status").toString().equals("1")) {
                    devs.setText("Online");
                    devs.setForeground(Color.GREEN);
                } else {
                    devs.setText("Offline");
                    devs.setForeground(Color.RED);
                }
            }
        }

    }//GEN-LAST:event_devcomItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed


    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int a = JOptionPane.showConfirmDialog(this, "Quit?", "Confirm Action", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.OK_OPTION) {

            String s = "";
            try {
                Process child = Runtime.getRuntime().exec("wmic csproduct get uuid");

                InputStream in = child.getInputStream();

                int c;
                while ((c = in.read()) != -1) {
                    //System.out.print((char) c);
                    s = s + (char) c;
                }

                s = s.substring(4);
                s = s.trim();

                in.close();

            } catch (Exception ex) {
            }

            lbllog.setBackground(ch);

            try {

                JSONObject tt = jj.Logout(js.get("id").toString(), s);
                // JOptionPane.showMessageDialog(null, ""+tt);
                if (tt.containsValue("Successfully Logged Out")) {

                    System.exit(0);
                }
            } catch (Exception ex) {
                Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String s = "";
        try {
            Process child = Runtime.getRuntime().exec("wmic csproduct get uuid");

            InputStream in = child.getInputStream();

            int c;
            while ((c = in.read()) != -1) {
                //System.out.print((char) c);
                s = s + (char) c;
            }

            s = s.substring(4);
            s = s.trim();

            in.close();

        } catch (Exception ex) {
        }

        try {
            int a = JOptionPane.showConfirmDialog(this, "Sure to Want to Remove this Device?");
            if (a == JOptionPane.YES_OPTION) {
                int y = jj.delDev(devi.getText());
                if (y == 1) {
                    JOptionPane.showMessageDialog(this, "Successfully Removed Device!");
                    if (devi.getText().equals(s)) {
                        remem m = new remem();
                        m.clear(js.get("id").toString());
                        System.exit(0);
                    } else {
                        getdev();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Unable To Remove Device!");
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void lblttsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblttsMouseClicked
        off();
        lbltts.setBackground(ch);
        tts.setVisible(true);
    }//GEN-LAST:event_lblttsMouseClicked

    private void lblttsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblttsMouseEntered
        if (lbltts.getBackground() != ch) {
            lbltts.setBackground(Color.darkGray);
        }
    }//GEN-LAST:event_lblttsMouseEntered

    private void lblttsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblttsMouseExited
        if (lbltts.getBackground() != ch) {
            lbltts.setBackground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_lblttsMouseExited

    private void chkttsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkttsMouseClicked
        if (chktts.isSelected()) {
            ar.set(0, "[tts]=1");
        } else {
            ar.set(0, "[tts]=0");
        }
        setConfig();
    }//GEN-LAST:event_chkttsMouseClicked

    private void chkttsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkttsItemStateChanged
        if (chktts.isSelected()) {
            pnltts.setVisible(true);
        } else {
            pnltts.setVisible(false);
        }
    }//GEN-LAST:event_chkttsItemStateChanged

    private void freqStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_freqStateChanged

    }//GEN-LAST:event_freqStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Main ms = new Main(vname.getSelectedItem().toString(), (float) freq.getValue() * 0.2f);
        ms.sp = "hello World";
        ms.run();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void lblaboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaboutMouseClicked
        off();
        lblabout.setBackground(ch);
        about.setVisible(true);
    }//GEN-LAST:event_lblaboutMouseClicked

    private void lblaboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaboutMouseEntered
        if (lblabout.getBackground() != ch) {
            lblabout.setBackground(Color.darkGray);
        }
    }//GEN-LAST:event_lblaboutMouseEntered

    private void lblaboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaboutMouseExited
        if (lblabout.getBackground() != ch) {
            lblabout.setBackground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_lblaboutMouseExited

    private void lblfavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfavMouseClicked
        off();
        lblfav.setBackground(ch);
        fav.setVisible(true);
    }//GEN-LAST:event_lblfavMouseClicked

    private void lblfavMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfavMouseEntered
        if (lblfav.getBackground() != ch) {
            lblfav.setBackground(Color.darkGray);
        }
    }//GEN-LAST:event_lblfavMouseEntered

    private void lblfavMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfavMouseExited
        if (lblfav.getBackground() != ch) {
            lblfav.setBackground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_lblfavMouseExited

    private void swwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swwActionPerformed
        if (sww.isSelected()) {
            try {

                ShellLink.createLink("AI.jar", "C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\AI.lnk");
            } catch (Exception ex) {
                Logger.getLogger(splash.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                Runtime.getRuntime().exec("cmd /c del \"C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\AI.lnk\"");

            } catch (Exception ex) {
                Logger.getLogger(splash.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_swwActionPerformed

    public void addfav(String fn, String data) {
        try {
            FileWriter fw = new FileWriter("assets/fav/" + fn + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(data);
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception ex) {
        }
    }

    public void delfav(String fn, String data) {
        try {

            FileWriter fw = new FileWriter("assets/fav/" + fn + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(data);
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception ex) {
        }
    }

    private void getFav() {
        try {

            FileReader fr = new FileReader("assets/fav/folder.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                tb1.addRow(new Object[]{a[0], a[1]});

            }
            br.close();
            fr.close();

            fr = new FileReader("assets/fav/audio.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                tb2.addRow(new Object[]{a[0], a[1]});
            }
            br.close();
            fr.close();

            fr = new FileReader("assets/fav/video.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                tb3.addRow(new Object[]{a[0], a[1]});
            }
            br.close();
            fr.close();

            fr = new FileReader("assets/fav/movies.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                tb4.addRow(new Object[]{a[0], a[1]});
            }

            fr = new FileReader("assets/fav/browse.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("`");
                tb5.addRow(new Object[]{a[0], a[1]});
            }
            br.close();
            fr.close();

            br.close();
            fr.close();
            fr = new FileReader("assets/fav/apps.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                tb6.addRow(new Object[]{a[0], a[1]});
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cngpss cn = new cngpss();
        cn.id = js.get("email").toString();
        cn.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            for (int i = 0; i < tb1.getRowCount(); i++) {
                if (tb1.getValueAt(i, 1).equals(fc.getCurrentDirectory())) {
                    JOptionPane.showMessageDialog(this, "Directory Already Added!");
                    return;
                }
            }
            String s1 = FileSystemView.getFileSystemView().getSystemDisplayName(fc.getCurrentDirectory());

            if (fc.getCurrentDirectory().getParent() == null) {
                tb1.addRow(new Object[]{s1, fc.getCurrentDirectory()});
                addfav("folder", s1 + "=" + fc.getCurrentDirectory());
            } else {
                tb1.addRow(new Object[]{fc.getCurrentDirectory(), fc.getCurrentDirectory()});
                addfav("folder", fc.getCurrentDirectory().getName() + "=" + fc.getCurrentDirectory());
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            for (int i = 0; i < tb2.getRowCount(); i++) {
                if (tb2.getValueAt(i, 1).equals(fc.getCurrentDirectory())) {
                    JOptionPane.showMessageDialog(this, "Directory Already Added!");
                    return;
                }
            }
            String s1 = FileSystemView.getFileSystemView().getSystemDisplayName(fc.getCurrentDirectory());

            if (fc.getCurrentDirectory().getParent() == null) {
                tb2.addRow(new Object[]{s1, fc.getCurrentDirectory()});
                addfav("audio", s1 + "=" + fc.getCurrentDirectory());
            } else {
                tb2.addRow(new Object[]{fc.getCurrentDirectory().getName(), fc.getCurrentDirectory()});
                addfav("audio", fc.getCurrentDirectory().getName() + "=" + fc.getCurrentDirectory());
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            for (int i = 0; i < tb3.getRowCount(); i++) {
                if (tb3.getValueAt(i, 1).equals(fc.getCurrentDirectory())) {
                    JOptionPane.showMessageDialog(this, "Directory Already Added!");
                    return;
                }
            }
            String s1 = FileSystemView.getFileSystemView().getSystemDisplayName(fc.getCurrentDirectory());

            if (fc.getCurrentDirectory().getParent() == null) {
                tb3.addRow(new Object[]{s1, fc.getCurrentDirectory()});
                addfav("video", s1 + "=" + fc.getCurrentDirectory());
            } else {
                tb3.addRow(new Object[]{fc.getCurrentDirectory().getName(), fc.getCurrentDirectory()});
                addfav("video", fc.getCurrentDirectory().getName() + "=" + fc.getCurrentDirectory());
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            for (int i = 0; i < tb4.getRowCount(); i++) {
                if (tb4.getValueAt(i, 1).equals(fc.getCurrentDirectory())) {
                    JOptionPane.showMessageDialog(this, "Directory Already Added!");
                    return;
                }
            }
            tb4.addRow(new Object[]{fc.getCurrentDirectory().getName(), fc.getCurrentDirectory()});
            delfav("movies", fc.getCurrentDirectory().getName() + "=" + fc.getCurrentDirectory());
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (tdoc.getSelectedRowCount() < 1) {
            return;
        }

        try {
            tb1.removeRow(tdoc.getSelectedRow());
            System.out.println(tb1.getRowCount());

            FileWriter fw = new FileWriter("assets/fav/folder.txt");
            fw.close();

            for (int i = 0; i < tb1.getRowCount(); i++) {
                delfav("folder", tb1.getValueAt(i, 0) + "=" + tb1.getValueAt(i, 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed
// tb2 = (DefaultTableModel) tas.getModel();
//        tb3 = (DefaultTableModel) tvs.getModel();
//        tb4 = (DefaultTableModel) tmv.getModel();
//        tb5 = (DefaultTableModel) tbrw.getModel();
//        tb6 = (DefaultTableModel) tapp.getModel();
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (tas.getSelectedRowCount() < 1) {
            return;
        }
        try {
            tb2.removeRow(tas.getSelectedRow());
            System.out.println(tb2.getRowCount());

            FileWriter fw = new FileWriter("assets/fav/audio.txt");
            fw.close();

            for (int i = 0; i < tb2.getRowCount(); i++) {
                delfav("audio", tb2.getValueAt(i, 0) + "=" + tb2.getValueAt(i, 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (tvs.getSelectedRowCount() < 1) {
            return;
        }
        try {
            tb3.removeRow(tvs.getSelectedRow());
            System.out.println(tb3.getRowCount());

            FileWriter fw = new FileWriter("assets/fav/video.txt");
            fw.close();

            for (int i = 0; i < tb3.getRowCount(); i++) {
                delfav("video", tb3.getValueAt(i, 0) + "=" + tb3.getValueAt(i, 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (tmv.getSelectedRowCount() < 1) {
            return;
        }
        try {
            tb4.removeRow(tmv.getSelectedRow());
            System.out.println(tb4.getRowCount());

            FileWriter fw = new FileWriter("assets/fav/movies.txt");
            fw.close();

            for (int i = 0; i < tb4.getRowCount(); i++) {
                delfav("movies", tb4.getValueAt(i, 0) + "=" + tb4.getValueAt(i, 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (tbrw.getSelectedRowCount() < 1) {
            return;
        }
        try {
            tb5.removeRow(tbrw.getSelectedRow());
            System.out.println(tb5.getRowCount());

            FileWriter fw = new FileWriter("assets/fav/browse.txt");
            fw.close();

            for (int i = 0; i < tb5.getRowCount(); i++) {
                delfav("browse", tb5.getValueAt(i, 0) + "`" + tb5.getValueAt(i, 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        website wb = new website(this);
        wb.setVisible(true);


    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tb6.addRow(new Object[]{fc.getCurrentDirectory().getName(), fc.getCurrentDirectory()});
            addfav("apps", fc.getCurrentDirectory().getName() + "=" + fc.getCurrentDirectory());
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (tapp.getSelectedRowCount() < 1) {
            return;
        }
        try {
            tb6.removeRow(tapp.getSelectedRow());
            System.out.println(tb6.getRowCount());

            FileWriter fw = new FileWriter("assets/fav/apps.txt");
            fw.close();

            for (int i = 0; i < tb6.getRowCount(); i++) {
                delfav("apps", tb6.getValueAt(i, 0) + "=" + tb5.getValueAt(i, 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void btrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrefreshActionPerformed
        getdev();        // TODO add your handling code here:
    }//GEN-LAST:event_btrefreshActionPerformed

    private void synbtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_synbtnItemStateChanged
        if (synbtn.getText().equalsIgnoreCase("turn off")) {
            synbtn.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else {
            synbtn.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }
    }//GEN-LAST:event_synbtnItemStateChanged

    private void swwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_swwMouseClicked

    }//GEN-LAST:event_swwMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
try{    FileWriter fw=new FileWriter("assets/prefer.txt");
    fw.close();
}
catch(Exception ex){}
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel about;
    private javax.swing.JButton btrefresh;
    private javax.swing.JCheckBox chktts;
    private javax.swing.JComboBox<String> combgen;
    private javax.swing.JButton dbtn;
    private javax.swing.JComboBox<String> devcom;
    private javax.swing.JLabel devi;
    private javax.swing.JLabel devn;
    private javax.swing.JLabel devs;
    private javax.swing.JLabel devt;
    private javax.swing.JPanel fav;
    private javax.swing.JButton fbtn;
    private javax.swing.JSlider freq;
    private javax.swing.JButton gbtn;
    private javax.swing.JPanel hh;
    private javax.swing.JPanel hh1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblabout;
    private javax.swing.JLabel lblacc;
    private javax.swing.JLabel lblcng;
    public javax.swing.JTextField lbldob;
    public javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfav;
    private javax.swing.JTextField lblfull;
    private javax.swing.JTextField lblgen;
    private javax.swing.JLabel lblimg;
    private javax.swing.JLabel lbllog;
    private javax.swing.JLabel lblset;
    private javax.swing.JLabel lblsyn;
    private javax.swing.JLabel lbltts;
    private javax.swing.JTextField lblun;
    private javax.swing.JLabel lblwel;
    private javax.swing.JPanel pnlacc;
    private javax.swing.JPanel pnltts;
    private javax.swing.JLabel qr;
    private javax.swing.JPanel set;
    private javax.swing.JButton ss;
    private javax.swing.JCheckBox sww;
    private javax.swing.JToggleButton synbtn;
    private javax.swing.JPanel sync;
    private javax.swing.JTable tapp;
    private javax.swing.JTable tas;
    public javax.swing.JTable tbrw;
    private javax.swing.JTable tdoc;
    private javax.swing.JTable tmv;
    private javax.swing.JPanel tts;
    private javax.swing.JTable tvs;
    private javax.swing.JButton ubtn;
    private javax.swing.JLabel uun;
    private javax.swing.JComboBox<String> vname;
    public javax.swing.JLabel z1;
    public javax.swing.JLabel z2;
    public javax.swing.JLabel z3;
    public javax.swing.JLabel z4;
    // End of variables declaration//GEN-END:variables
Config cf = new Config();

    private void getConfig() {
        cf.read();
        this.ar = cf.ar;

        int y = Integer.parseInt(ar.get(0).toString().split("=")[1]);
        if (y == 1) {
            chktts.setSelected(true);
        } else {
            chktts.setSelected(false);
        }
        vname.setSelectedItem(ar.get(1).toString().split("=")[1]);
        int fr = (int) (Math.ceil(Double.parseDouble(ar.get(2).toString().split("=")[1])));
        freq.setValue(fr);

//float ff= Float.parseFloat(ar.get(2).toString().split("=")[1])*0.2f;
    }

    void setConfig() {

        if (chktts.isSelected()) {
            ar.set(0, "[tts]=1");
        } else {
            ar.set(0, "[tts]=0");
        }
        ar.set(1, "[voice]=" + vname.getSelectedItem().toString());
        ar.set(2, "[freq]=" + freq.getValue());

        cf.ar = this.ar;

        cf.write();
        getConfig();
    }

    private void getdev() {
        try {
            devcom.removeAllItems();
            dev = jj.getDevices(js.get("id").toString());
            for (int i = 0; i < dev.length; i++) {
                devcom.addItem(dev[i].get("device_name").toString());
            }

        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void off() {
        hh.setVisible(false);
        hh1.setVisible(true);
        lblwel.setBackground(new Color(102, 102, 102));
        lblacc.setBackground(new Color(102, 102, 102));
        pnlacc.setVisible(false);
        lblset.setBackground(new Color(102, 102, 102));
        sync.setVisible(false);
        set.setVisible(false);
        lblfav.setBackground(new Color(102, 102, 102));
        lblsyn.setBackground(new Color(102, 102, 102));
        lblcng.setBackground(new Color(102, 102, 102));
        lbllog.setBackground(new Color(102, 102, 102));
        lbltts.setBackground(new Color(102, 102, 102));
        tts.setVisible(false);
        fav.setVisible(false);
        about.setVisible(false);
        lblabout.setBackground(new Color(102, 102, 102));
    }

    public void off1() {
        lblacc.setBackground(new Color(102, 102, 102));
        pnlacc.setVisible(false);
        lblset.setBackground(new Color(102, 102, 102));
        lbltts.setBackground(new Color(102, 102, 102));
        lblsyn.setBackground(new Color(102, 102, 102));
        lblfav.setBackground(new Color(102, 102, 102));
        sync.setVisible(false);
        tts.setVisible(false);
        fav.setVisible(false);
        lblcng.setBackground(new Color(102, 102, 102));
        lbllog.setBackground(new Color(102, 102, 102));
        about.setVisible(false);
        lblabout.setBackground(new Color(102, 102, 102));
    }
}
