/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ULTRON
 */
public class AudPlay extends javax.swing.JFrame {

    DefaultTableModel tm;
    ArrayList sng = new ArrayList();
    int res = 0, mn = 0, sc = 0, m1, s1;

    MediaPlayer play;
    Media m;
    int pos=0;
    Slid sd;
AudRecog ob=new AudRecog(this);
    public AudPlay() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        tm = (DefaultTableModel) list.getModel();
        load();
        pau.setEnabled(false);
        bck.setIcon(new ImageIcon("assets/bck.jpg"));
       
        pic.setIcon(new ImageIcon("assets/mlogo.png"));
        lblpl.setIcon(new ImageIcon("assets/plist.png"));
        lblvl.setIcon(new ImageIcon("assets/vicon.png"));
        
        
        
        
        list.setOpaque(false);
        ((DefaultTableCellRenderer) list.getDefaultRenderer(Object.class)).setOpaque(false);
        ScrollPane.setOpaque(false);
        ScrollPane.getViewport().setOpaque(false);
        list.setShowGrid(false);
        this.setSize(850, this.getHeight());
        
          try {
            ob.Reco();
        } catch (Exception ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load() {
        try {
            FileReader fr = new FileReader("assets/fav/playlist.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                tm.addRow(new Object[]{s.split("=")[0]});
                sng.add(s.split("=")[1]);
            }
            list.changeSelection(0, 0, false, false);
        } catch (Exception ex) {
            FileWriter fw;
            try {
                fw = new FileWriter("assets/fav/playlist.txt");
                fw.close();
            } catch (IOException ex1) {
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sname = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();
        lblvol = new javax.swing.JLabel();
        lblpl = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();
        lblvl = new javax.swing.JLabel();
        vol = new javax.swing.JSlider();
        stp1 = new javax.swing.JButton();
        response = new javax.swing.JLabel();
        stp2 = new javax.swing.JButton();
        ply = new javax.swing.JButton();
        pau = new javax.swing.JButton();
        stp = new javax.swing.JButton();
        add = new javax.swing.JButton();
        rem = new javax.swing.JButton();
        tdur = new javax.swing.JLabel();
        cdur = new javax.swing.JLabel();
        sld = new javax.swing.JSlider();
        bck = new javax.swing.JLabel();

        setTitle("Audio Player");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sname.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        sname.setForeground(new java.awt.Color(255, 255, 255));
        sname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 380, 40));

        ScrollPane.setBackground(new java.awt.Color(255, 255, 255));

        list.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Your Playlist"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        list.setColumnSelectionAllowed(true);
        list.setOpaque(false);
        list.setRowHeight(25);
        list.setSelectionBackground(new java.awt.Color(102, 102, 102));
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.getTableHeader().setReorderingAllowed(false);
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(list);
        list.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (list.getColumnModel().getColumnCount() > 0) {
            list.getColumnModel().getColumn(0).setResizable(false);
            list.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        getContentPane().add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 290, 430));

        lblvol.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        lblvol.setForeground(new java.awt.Color(255, 255, 255));
        lblvol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblvol.setText("50");
        getContentPane().add(lblvol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 30, 30));

        lblpl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblplMouseClicked(evt);
            }
        });
        getContentPane().add(lblpl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 50, 50));
        getContentPane().add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 280, 280));

        lblvl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblvlMouseClicked(evt);
            }
        });
        getContentPane().add(lblvl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 50, 50));

        vol.setBackground(new java.awt.Color(153, 153, 153));
        vol.setMajorTickSpacing(1);
        vol.setOrientation(javax.swing.JSlider.VERTICAL);
        vol.setOpaque(false);
        vol.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volStateChanged(evt);
            }
        });
        vol.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                volMouseWheelMoved(evt);
            }
        });
        vol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volMouseClicked(evt);
            }
        });
        getContentPane().add(vol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 180));

        stp1.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        stp1.setText("<<");
        stp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stp1ActionPerformed(evt);
            }
        });
        getContentPane().add(stp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 60, 30));

        response.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        response.setForeground(new java.awt.Color(255, 255, 51));
        response.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(response, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 410, 30));

        stp2.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        stp2.setText(">>");
        stp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stp2ActionPerformed(evt);
            }
        });
        getContentPane().add(stp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 60, 30));

        ply.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        ply.setText("Play >");
        ply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plyActionPerformed(evt);
            }
        });
        getContentPane().add(ply, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 90, 30));

        pau.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        pau.setText("Pause ||");
        pau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauActionPerformed(evt);
            }
        });
        getContentPane().add(pau, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 90, 30));

        stp.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        stp.setText("Stop []");
        stp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stpActionPerformed(evt);
            }
        });
        getContentPane().add(stp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 90, 30));

        add.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        add.setText("Add Song");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 150, 40));

        rem.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        rem.setText("Remove Song");
        rem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remActionPerformed(evt);
            }
        });
        getContentPane().add(rem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 140, 40));

        tdur.setBackground(new java.awt.Color(0, 0, 0));
        tdur.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tdur.setForeground(new java.awt.Color(255, 255, 255));
        tdur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tdur.setText("00:00");
        getContentPane().add(tdur, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 50, 40));

        cdur.setBackground(new java.awt.Color(0, 0, 0));
        cdur.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cdur.setForeground(new java.awt.Color(255, 255, 255));
        cdur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cdur.setText("00:00");
        getContentPane().add(cdur, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 50, 40));

        sld.setBackground(new java.awt.Color(153, 153, 153));
        sld.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sld.setForeground(new java.awt.Color(255, 255, 255));
        sld.setMajorTickSpacing(1);
        sld.setMinorTickSpacing(1);
        sld.setToolTipText("Seek");
        sld.setValue(0);
        sld.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldStateChanged(evt);
            }
        });
        sld.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                sldMouseWheelMoved(evt);
            }
        });
        sld.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sldMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sldMouseReleased(evt);
            }
        });
        getContentPane().add(sld, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 450, 40));

        bck.setOpaque(true);
        getContentPane().add(bck, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void plyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plyActionPerformed
        if (tm.getRowCount() > 0) {
            if (list.getSelectedRowCount() == 0) {
                list.changeSelection(0, 0, false, false);
            }
            if (play != null) {
                play.stop();
                sd.stop();
                mn = 0;
                sc = 0;
                sld.setValue(0);
                setcdur();
            }
            pau.setEnabled(true);
            if (pau.getText().equals("Resume..")) {
                pau.setText("Pause ||");
            }

            go(sng.get(list.getSelectedRow()).toString());
            sname.setText(list.getValueAt(list.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_plyActionPerformed

    private void stpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stpActionPerformed
        if (tm.getRowCount() > 0) {
            play.stop();
            sd.stop();
            if (pau.getText().equals("Resume..")) {
                pau.setText("Pause ||");
            }
            mn = 0;
            sc = 0;
            sld.setValue(0);
            setcdur();
            pau.setEnabled(false);
        }
    }//GEN-LAST:event_stpActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
       fc.addChoosableFileFilter(new FileNameExtensionFilter(".mp3", "mp3"));
       fc.addChoosableFileFilter(new FileNameExtensionFilter(".wav", "wav"));
       fc.addChoosableFileFilter(new FileNameExtensionFilter(".avi", "avi"));
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tm.addRow(new Object[]{fc.getSelectedFile().getName()});
            list.changeSelection(tm.getRowCount()-1, 0, false, false);
            sng.add(fc.getSelectedFile().getAbsoluteFile());
            addsong(fc.getSelectedFile().getName() + "=" + fc.getSelectedFile().getAbsoluteFile());
        }
    }//GEN-LAST:event_addActionPerformed

    private void remActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remActionPerformed
        if (list.getSelectedRowCount() > 0) {
            try {
                sng.remove(list.getSelectedRow());
                tm.removeRow(list.getSelectedRow());
                FileWriter fw = new FileWriter("assets/fav/playlist.txt");
                fw.close();

                for (int i = 0; i < tm.getRowCount(); i++) {
                    delsong(tm.getValueAt(i, 0) + "=" + sng.get(i));
                }
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_remActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (play != null) {
            play.stop();
            sd.stop();
        }
    }//GEN-LAST:event_formWindowClosing

    private void pauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauActionPerformed
        if (tm.getRowCount() > 0) {
            if (pau.getText().equals("Pause ||")) {
                play.pause();
                sd.suspend();
                pau.setText("Resume..");
            } else {
                play.play();
                sd.resume();
                pau.setText("Pause ||");
            }
        }
    }//GEN-LAST:event_pauActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
if(evt.getClickCount()==2)
{
if (tm.getRowCount() > 0) {
            if (list.getSelectedRowCount() == 0) {
                list.changeSelection(0, 0, false, false);
            }
            if (play != null) {
                play.stop();
                sd.stop();
                mn = 0;
                sc = 0;
                sld.setValue(0);
                setcdur();
            }
            pau.setEnabled(true);
            if (pau.getText().equals("Resume..")) {
                pau.setText("Pause ||");
            }

            go(sng.get(list.getSelectedRow()).toString());
            sname.setText(list.getValueAt(list.getSelectedRow(), 0).toString());
        }
}
    }//GEN-LAST:event_listMouseClicked

    private void sldStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldStateChanged
mn=(int)play.getCurrentTime().toMinutes();

if(play.getCurrentTime().toSeconds()<=60.0)
sc=(int)play.getCurrentTime().toSeconds();
else
sc=(int)play.getCurrentTime().toSeconds()%60;



    }//GEN-LAST:event_sldStateChanged

    private void stp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stp1ActionPerformed
if (list.getRowCount() > 0) {
            if (list.getSelectedRowCount() > 0) {
                pos = list.getSelectedRow() - 1;
                if (pos == -1) {
                    pos = list.getRowCount()-1;
                }
                if (pos >-1) {
                    if (play != null) {
                        play.stop();
                        sd.stop();
                        mn = 0;
                        sc = 0;
                        sld.setValue(0);
                        setcdur();
                    }
                    pau.setEnabled(true);
                    if (pau.getText().equals("Resume..")) {
                        pau.setText("Pause ||");
                    }
                    list.changeSelection(pos, 0, false, false);
                    go(sng.get(pos).toString());
                    sname.setText(list.getValueAt(pos, 0).toString());
                }
            } else {
                list.changeSelection(0, 0, false, false);
                ply.doClick();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_stp1ActionPerformed

    private void stp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stp2ActionPerformed
if (list.getRowCount() > 0) {
            if (list.getSelectedRowCount() > 0) {
                pos = list.getSelectedRow() + 1;
                if (pos == list.getRowCount()) {
                    pos = 0;
                }
                if (pos < list.getRowCount()) {
                    if (play != null) {
                        play.stop();
                        sd.stop();
                        mn = 0;
                        sc = 0;
                        sld.setValue(0);
                        setcdur();
                    }
                    pau.setEnabled(true);
                    if (pau.getText().equals("Resume..")) {
                        pau.setText("Pause ||");
                    }
                    list.changeSelection(pos, 0, false, false);
                    go(sng.get(pos).toString());
                    sname.setText(list.getValueAt(pos, 0).toString());
                }
            } else {
                list.changeSelection(0, 0, false, false);
                ply.doClick();
            }
        }
    }//GEN-LAST:event_stp2ActionPerformed

    private void sldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldMouseClicked
   // TODO add your handling code here:
    }//GEN-LAST:event_sldMouseClicked

    private void sldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldMouseReleased
play.seek(Duration.seconds((double)sld.getValue()));         // TODO add your handling code here:
    }//GEN-LAST:event_sldMouseReleased

    private void lblvlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblvlMouseClicked
mute();
    }//GEN-LAST:event_lblvlMouseClicked
public void mute()
{
try{
if(play.isMute()==false)
{
    play.setMute(true);
           lblvl.setIcon(new ImageIcon("assets/vmute.png"));
}
else{
play.setMute(false);
       lblvl.setIcon(new ImageIcon("assets/vicon.png"));
}
}catch(Exception e){}
}
    private void lblplMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblplMouseClicked
        if (this.getWidth() == 850) {
            this.setSize(550, this.getHeight());
        } else {
            this.setSize(850, this.getHeight());
        }
    }//GEN-LAST:event_lblplMouseClicked

    private void volStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volStateChanged
        try {
            lblvol.setText(vol.getValue()+"");
            play.setVolume((double) vol.getValue() / 100);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_volStateChanged

    private void volMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_volMouseWheelMoved
        if (evt.getWheelRotation() < 0) {
            vol.setValue(vol.getValue() + evt.getScrollAmount());
            try {
                lblvol.setText(vol.getValue()+"");
                play.setVolume((double) vol.getValue() / 100);

            } catch (Exception e) {
            }
        } else {
            vol.setValue(vol.getValue() - evt.getScrollAmount());
            try {
                lblvol.setText(vol.getValue()+"");
                play.setVolume((double) vol.getValue() / 100);

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_volMouseWheelMoved

    private void sldMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_sldMouseWheelMoved
      try{
        if(evt.getWheelRotation()<0)
        {
            sld.setValue(sld.getValue()+evt.getScrollAmount());
        }
        else
        {
            sld.setValue(sld.getValue()-evt.getScrollAmount());
        }
            play.seek(Duration.seconds((double)sld.getValue())); 
            mn=(int)play.getCurrentTime().toMinutes();
            if(play.getCurrentTime().toSeconds()<=60.0)
            sc=(int)play.getCurrentTime().toSeconds();
            else
            sc=(int)play.getCurrentTime().toSeconds()%60;
      }catch(Exception e){}
        
    }//GEN-LAST:event_sldMouseWheelMoved

    private void volMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volMouseClicked

    }//GEN-LAST:event_volMouseClicked

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public void go(String song) {
        try {
            com.sun.javafx.application.PlatformImpl.startup(() -> {
            });
            m = new Media(new File(song).toURI().toString());
            play = new MediaPlayer(m);
            play.setVolume((double)vol.getValue()/100);
            play.play();

            play.setOnReady(new Runnable() {

                @Override
                public void run() {
                    double tme = m.getDuration().toSeconds() / 60;
                    long tms = (long) Math.floor(tme * 60 * 1000);
                    Date date = new Date(tms);
                    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
                    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

               pic.setIcon(new ImageIcon("assets/mlogo.png"));

                    // display media's metadata
                    for (Map.Entry<String, Object> entry : m.getMetadata().entrySet()) {
                        //System.out.println(entry.getKey() + ": " + entry.getValue());
                        if (entry.getKey().equalsIgnoreCase("image")) {
                            BufferedImage image = SwingFXUtils.fromFXImage((javafx.scene.image.Image) entry.getValue(), null);
                            image = resize(image, 280, 280);
                            pic.setVisible(true);
                            pic.setIcon(new ImageIcon(image));
                        }
                    }

                    tdur.setText(sdf.format(date));
                    m1 = Integer.parseInt(sdf.format(date).split(":")[0]);
                    s1 = Integer.parseInt(sdf.format(date).split(":")[1]);
                    sld.setMaximum((m1 * 60) + s1);
                    
                    sd = new Slid();
                    sd.start();
                }
            }
            );
            
             play.setOnEndOfMedia(new Runnable() {
                @Override
                
                public void run() {
                    stp2.doClick();
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setcdur() {
        String cd = "";
        if (mn < 10) {
            cd = cd + "0" + mn + ":";
        } else {
            cd = cd + mn + ":";
        }
        if (sc < 10) {
            cd = cd + "0" + sc;
        } else {
            cd = cd + sc;
        }
        cdur.setText(cd);
    }

    class Slid extends Thread {

        public void run() {
            while (true) {
//                sld.setValue((mn * 60) + sc);
//                
//                // System.out.println(sld.getValue()/60+" "+sld.getValue()%60);
                setcdur();
                sc++;
                if (mn == m1 && sc == s1) {
                    this.stop();
                }
                if (sc == 60) {
                    sc = 0;
                    mn++;
                }
                
                    sld.setValue(sld.getValue()+1);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException ex) {
               }


            }
        }
    }

    public void addsong(String data) {
        try {
            FileWriter fw = new FileWriter("assets/fav/playlist.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(data);
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception ex) {
            FileWriter fw;
            try {
                fw = new FileWriter("assets/fav/playlist.txt");
                fw.close();
            } catch (IOException ex1) {
            }
        }
    }

    public void delsong(String data) {
        try {
            FileWriter fw = new FileWriter("assets/fav/playlist.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(data);
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception ex) {
            FileWriter fw;
            try {
                fw = new FileWriter("assets/fav/playlist.txt");
                fw.close();
            } catch (IOException ex1) {
            }
        }
    }

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
            java.util.logging.Logger.getLogger(AudPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AudPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AudPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AudPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AudPlay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    public javax.swing.JButton add;
    private javax.swing.JLabel bck;
    private javax.swing.JLabel cdur;
    private javax.swing.JLabel lblpl;
    public javax.swing.JLabel lblvl;
    private javax.swing.JLabel lblvol;
    private javax.swing.JTable list;
    public javax.swing.JButton pau;
    private javax.swing.JLabel pic;
    public javax.swing.JButton ply;
    public javax.swing.JButton rem;
    public javax.swing.JLabel response;
    public javax.swing.JSlider sld;
    private javax.swing.JLabel sname;
    public javax.swing.JButton stp;
    public javax.swing.JButton stp1;
    public javax.swing.JButton stp2;
    private javax.swing.JLabel tdur;
    public javax.swing.JSlider vol;
    // End of variables declaration//GEN-END:variables
}
