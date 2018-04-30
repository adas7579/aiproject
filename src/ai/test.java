package ai;

import application.*;
import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Desktop;
import Games.*;
/**
 *
 * @author VISION
 */
public class test extends javax.swing.JFrame {

    private static final String COMMIT_ACTION = "commit";
    public static int wp = 0;
    String timeStamp, note = "";
    Windows w = new Windows();
    Prefernces pp = new Prefernces();
    SpRecog ob;
    Main ms = null;
    JMake jj = new JMake();
    public JSONObject detail, tt;
    public String pass, uid,email;
    noteedit n;
    notenew nn;
    ArrayList conn = new ArrayList();
    Autocomplete autoComplete;
    int hov;
    Sync syn;
    public test(String uid, ArrayList con, String email,Sync syn,int hv) {
            task();
            
            
        this.uid = uid;
        w.email = email;
        hov=hv;
        this.email=email;
        this.syn=syn;
        if (con.get(0).toString().split("=")[1].equals("1")) {
            String name = con.get(1).toString().split("=")[1];
            float frq = Float.parseFloat(con.get(2).toString().split("=")[1]) * 0.2f;
            ms = new Main(name, frq);
        }
        try{
        ob = new SpRecog(this, pp, con, uid,email,detail);
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"No Microphone Detected!\nClosing Application.....");
        System.exit(0);
        }
        ob.jj = jj;
        conn = con;
        initComponents();

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();

        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        int taskBarHeight = scrnSize.height - winSize.height;

        int y = (int) rect.getMaxY() - this.getHeight() - taskBarHeight;
        this.setLocation(x, y);

        alarm a = new alarm(uid);
        a.start();
        remnd r = new remnd(uid);
        r.start();
        

        // System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + uid);
        n = new noteedit(new String[]{"0", "1", "2", "3"}, null);
        nn = new notenew(new String[]{"0", "1", "2", "3"});
        n.jj = jj;
        ob.uid = uid;
        w.uid = uid;

        lb.setIcon(null);
        label.setIcon(new ImageIcon("assets/mute.png"));
        //label.setIcon(new ImageIcon("assets/mute.png"));
        pic.setIcon(new ImageIcon("assets/dots.png"));
//        try {
//            ob.Reco();
//        } catch (Exception ex) {
//            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }

        this.setBackground(new Color(0, 0, 0, 0));
        pp.Read();

        // Our words to complete
        //   ArrayList keywords = new ArrayList(5);
//        keywords.add("example");
//        keywords.add("autocomplete");
//        keywords.add("stackabuse");
//        keywords.add("java");
        //   System.out.print(pp.list);
        autoComplete = new Autocomplete(response, pp.list);
        response.getDocument().addDocumentListener(autoComplete);

// Maps the tab key to the commit action, which finishes the autocomplete
// when given a suggestion
        response.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new javax.swing.JLabel();
        response = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        opt = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        b1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InArCo");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pic.setBackground(new java.awt.Color(0, 0, 0));
        pic.setToolTipText("Menu");
        pic.setOpaque(true);
        pic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                picMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                picMouseEntered(evt);
            }
        });
        getContentPane().add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 20, 50));

        response.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                responseMouseClicked(evt);
            }
        });
        response.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                responseKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                responseKeyReleased(evt);
            }
        });
        getContentPane().add(response, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 200, 30));
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 200));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 240, 50));

        opt.setBackground(new java.awt.Color(0, 0, 0));
        opt.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        opt.setForeground(new java.awt.Color(255, 255, 255));
        opt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opt.setText("Need assistance?");
        opt.setOpaque(true);
        opt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optMouseClicked(evt);
            }
        });
        getContentPane().add(opt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 170, 50));

        label.setBackground(new java.awt.Color(0, 0, 0));
        label.setText("jLabel3");
        label.setOpaque(true);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
        });
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 50, 50));

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        b1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b1.setText(">");
        b1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        b1.setOpaque(true);
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b1MouseEntered(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 20, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 MenuItem lis;
    SystemTray tray;
     TrayIcon trayIcon;
private void task()
{
if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        java.awt.Image image = Toolkit.getDefaultToolkit().getImage("assets/sys.png");
       trayIcon  =  new TrayIcon(image);
     tray = SystemTray.getSystemTray();
       
        // Create a pop-up menu components
        MenuItem wel = new MenuItem("Welcome");
//        CheckboxMenuItem cb1 = new CheckboxMenuItem("Set auto size");
//        CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
  
       lis = new MenuItem("Listen");
//        MenuItem errorItem = new MenuItem("Error");
//        MenuItem warningItem = new MenuItem("Warning");
        MenuItem mute = new MenuItem("Clear");

        MenuItem log = new MenuItem("Logout");
        MenuItem exit = new MenuItem("Exit");
       
        //Add components to pop-up menu
        popup.add(wel);
      popup.addSeparator();
      popup.add(lis);
        popup.add(mute);
        popup.addSeparator();
      
        popup.add(log);
//        displayMenu.add(errorItem);
//        displayMenu.add(warningItem);
//        displayMenu.add(infoItem);
//        displayMenu.add(noneItem);
        popup.add(exit);       
        trayIcon.setPopupMenu(popup);
        
           wel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
         try {
                JSONObject qw = jj.getUser(detail.get("email").toString());
                welcome w = new welcome(qw,syn);
                w.pass = pass;
               tray.remove(trayIcon);
                
                w.setVisible(true);
                setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
           
       lis.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          close();
        }
    });
            
             mute.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          response.setText("");
        }
    });
        
        
         log.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          logout();
        }
    });
        
        exit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            exit();
        }
    });
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }        
        
        
        
        
}
    private void responseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_responseMouseClicked
        lb.setIcon(null);
        label.setIcon(new ImageIcon("assets/mute.png"));
        if (ob != null) {
            ob.duplex.stopSpeechRecognition();
            ob = null;
        }

    }//GEN-LAST:event_responseMouseClicked

    private void labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseClicked
        close();
    }//GEN-LAST:event_labelMouseClicked
    public void close() {
        if (lb.getIcon() == null) {
            lb.setIcon(new ImageIcon("assets/listening.gif"));
            label.setIcon(new ImageIcon("assets/unmute.png"));
            try {
                ob = new SpRecog(this, pp, conn, uid,email,detail);
                ob.jj = jj;
                ob.uid = uid;
                ob.Reco();
                //ob.execute();
            } catch (Exception ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lb.setIcon(null);
            label.setIcon(new ImageIcon("assets/mute.png"));
            ob.duplex.stopSpeechRecognition();
            ob = null;
            response.setText("");
        }
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ob.duplex.stopSpeechRecognition();
        ob = null;      // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        anime();      

// TODO add your handling code here:
//ms=null;
    }//GEN-LAST:event_b1MouseClicked

    private void responseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_responseKeyPressed
        if (evt.getKeyCode() == 10) {
            String vf[] = response.getText().split(" ");
            for (String s : vf) {
                if (!pp.list.contains(s) && s.matches("\\D+")) {
                    pp.list.add(s);
                }
                pp.Write();

            }
            response.getDocument().removeDocumentListener(autoComplete);
            autoComplete=null;
            autoComplete = new Autocomplete(response, pp.list);         
            response.getDocument().addDocumentListener(autoComplete);
            response.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
            System.out.print(pp.list);
            start(response.getText());
        }
    }//GEN-LAST:event_responseKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void picMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMouseClicked
        if (evt.getClickCount() == 1) {
            try {
                JSONObject qw = jj.getUser(detail.get("email").toString());
                welcome w = new welcome(qw,syn);
                w.pass = pass;
               
                
                w.setVisible(true);
                tray.remove(trayIcon);
                this.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_picMouseClicked

    private void optMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optMouseClicked
//ms=new Main();

    }//GEN-LAST:event_optMouseClicked

    private void picMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMouseEntered
        //if(this.getWidth()==20)anime();
    }//GEN-LAST:event_picMouseEntered

    private void b1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseEntered
        if (hov==1 && this.getWidth() == 20) {
            anime();
        }
    }//GEN-LAST:event_b1MouseEntered

    private void responseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_responseKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_responseKeyReleased

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
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //     new test().setVisible(true);
            }
        });
    }

    public int execute(String e) {
        try {
            if (e.equalsIgnoreCase("chrome.exe")) {
                if (new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe").exists()) {
                    Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                } else if (new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe").exists()) {
                    Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                } else {
                    this.opt.setText("Chrome not installed. Opening default web browser...");
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI("http://www.google.com"));
                        } catch (Exception ex) {
                        }
                    }
                    return 1;
                }
            } else {
                System.out.println("Executing: cmd /c start \"\" " + e);
                Runtime.getRuntime().exec("cmd /c start \"\" " + e);
            }
        } catch (Exception ex) {
        }
        return 0;
    }

    int wt;

    public void anime() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX();

        if (wp == 0) {
            wp = 1;
            this.setLocation(x - 20, this.getY());
            wt = this.getWidth();
            b1.setText("<");
            response.setText("");
            lb.setIcon(null);
            label.setIcon(new ImageIcon("assets/mute.png"));
            if (ob != null) {
                ob.duplex.stopSpeechRecognition();
                ob = null;
            }
            this.setBounds(this.getX(), this.getY(), 20, this.getHeight());
             lis.setEnabled(false);
        } else {
            wp = 0;
            this.setBounds(this.getX(), this.getY(), wt, this.getHeight());
            b1.setText(">");
            this.setLocation(x - this.getWidth(), this.getY());
               lis.setEnabled(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lb;
    public javax.swing.JLabel opt;
    private javax.swing.JLabel pic;
    public javax.swing.JTextField response;
    // End of variables declaration//GEN-END:variables

    int sig = 0;

    Greetings grr = new Greetings();
    int nt = 0;

    void start(String output) {

        String aaa = grr.greet(output);
        if (!aaa.equals("")) {
            opt.setText(aaa);
            try {
                ms.sp = this.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            return;
        }

        if (output.contains("note") && (output.contains("make") || output.contains("type")|| output.contains("create"))) {
            nt = 1;
            Instant in = Instant.now();
            String timeStamp = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
            nn = new notenew(new String[]{uid, in.toString(), timeStamp, ""});
            nn.jj = jj;
            nn.user = detail;
            this.opt.setText("Creating a Note");

            try {
                ms.sp = this.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            nn.setVisible(true);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            this.opt.setText("Need assistance?");
            return;
        } else if ((output.toLowerCase().equalsIgnoreCase("save it") || output.toLowerCase().equalsIgnoreCase("save note")) && (n.isVisible() == true)) {
            nt = 0;
            write(timeStamp, note);
            this.opt.setText("Saving a Note");

            try {
                ms.sp = this.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            nn.setVisible(false);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            this.opt.setText("Need assistance?");
//            write("----");
            return;
        } else if (output.toLowerCase().contains("show") && output.toLowerCase().contains("note")) {
            nt = 0;

            notes n = new notes(uid,email);
            n.jj = jj;
            n.user = detail;
            this.opt.setText("Showing Notes");
            try {
                ms.sp = this.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            n.setVisible(true);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            this.opt.setText("Need assistance?");
            return;
        } else if (output.toLowerCase().contains("close") && output.toLowerCase().contains("notes")) {
            this.opt.setText("Closing Notes");
            try {
                ms.sp = this.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            n.setVisible(false);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            this.opt.setText("Need assistance?");
            return;
        } else if (output.equalsIgnoreCase("Listen")) {
            sig = 0;
            this.anime();

        } else if (output.equalsIgnoreCase("discard")) {
            // JOptionPane.showMessageDialog(null, "hello");
            sig = 1;
            this.anime();
            this.response.setText("");
        } else if (output.equalsIgnoreCase("logout")) {

//               
 logout();

        } else if (output.equalsIgnoreCase("exit")) {

          exit();
        }
        else if (output.equalsIgnoreCase("my calculator")) {

          calc cal=new calc();
          cal.setVisible(true);
          return;
        }
        
        else if (output.equalsIgnoreCase("my playlist")) {

          AudPlay ap=new AudPlay();
          ap.setVisible(true);
          return;
        } 
         else if (output.equalsIgnoreCase("my browser")) {

          Web wb=new Web();
          wb.main();
          return;
        } 
        
         else if ((output.toLowerCase().contains("play game"))||(output.toLowerCase().contains("show tools"))) {

          Game gm=new Game();
          gm.setVisible(true);
          return;
        }
        

   
            if (sig == 0) {
                String tt[] = w.pr(output);
                
                if (tt[0] != "@#$") {
                    int ch = execute(tt[0]);
                    if (ch == 0) {
                        opt.setText("Opening " + tt[1] + " ...");
                        try {
                            ms.sp = this.opt.getText();
                            ms.run();
                        } catch (Exception e) {
                            System.out.println("TTS is Diasabled!");
                        }
                    }
                } else {
                    opt.setText(tt[1]);
                    
                    System.out.println(tt[0]+" "+tt[1]);
                    if (this.opt.getText() != "") {
                        try {
                           // JOptionPane.showMessageDialog(null, opt.getText());
                             Thread.sleep(1000);
                            ms.sp = this.opt.getText();
                            ms.run();
                        } catch (Exception e) {
                            System.out.println("TTS is Diasabled!");
                        }
                    } else {
                        sorry(output);
                    }
                }
            }

        try {
            Thread.sleep(1000);
    this.opt.setText("Need assistance?");
        this.response.setText("");
        } catch (InterruptedException ex) {
           
        }
       
    }
private void exit()
{
  this.opt.setText("Good day!");
            try {
                ms.sp = this.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            String s = "";
            try {
                Process child = Runtime.getRuntime().exec("wmic csproduct get uuid");
                InputStream in = child.getInputStream();
                int c;
                while ((c = in.read()) != -1) {
                    s = s + (char) c;
                }
                s = s.substring(4);
                s = s.trim();
                in.close();
            } catch (Exception ex) {
            }
            try {

                JSONObject tt = jj.Logout(uid, s);
                // JOptionPane.showMessageDialog(null, ""+tt);
               
                    System.exit(0);
                
            } catch (Exception ex) {
                Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
}
private void logout()
{
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

                JSONObject tt = jj.Logout(uid, s);
                // JOptionPane.showMessageDialog(null, ""+tt);
                if (tt.containsValue("Successfully Logged Out")) {
                    remem r = new remem();
                    r.clear(uid);
                    System.exit(0);
                }
            } catch (Exception ex) {
                Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    public void sorry(String a) {

            //        this.opt.setText("Sorry! I Didn't Understand.");
//        try {
//            ms.sp = this.opt.getText();
//            ms.run();
//        } catch (Exception e) {
//            System.out.println("TTS is Diasabled!");
//        }
//        try {
//            Thread.sleep(1000);
//
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SpRecog.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        this.opt.setText("Need assistance?");
//        this.response.setText("");
        try {
        JSONObject tt=jj.aiResponse("desktop:"+a);
        Aires ai=new Aires(tt,a);
        ai.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void write(String t, String s) {
        try {
            DB bb = new DB(uid);
            System.out.println(uid);
            bb.open();
            bb.insertData("insert into notes values('" + t + "','" + s + "')");
            bb.close();
        } catch (Exception ex) {
        }
    }

}
