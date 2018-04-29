package ai;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.json.simple.JSONObject;

public class Sync extends Thread {

    JMake jj = new JMake();

    String ud = "",email="";
    ArrayList ar = new ArrayList();

    public Sync(String ud,String email) {
        this.ud = ud;
        this.email=email;
        DB bb = new DB(ud);

        //  -----------  ALARM   ----------
        bb.open();
        ResultSet rs = bb.getData("select * from alarm");

        try {
            while (rs.next()) {
                ar.add(rs.getString("alarm_id").toString() + "=" + rs.getString("alarm_time").toString() + "=" + rs.getString("alarm_text").toString());
            }
            JSONObject tt[] = jj.getAlarm(ud);

            for (int i = 0; i < tt.length; i++) {
                if (!ar.contains(tt[i].get("alarm_id"))) {
                    ar.add(tt[i].get("alarm_id") + "=" + tt[i].get("alarm_time") + "=" + tt[i].get("alarm_text"));
                }
            }
            bb.insertData("delete from alarm");
            for (int j = 0; j < tt.length; j++) {
                jj.deleteAlarm(new String[]{ud, tt[j].get("alarm_id").toString()});
            }
            for (int j = 0; j < ar.size(); j++) {
                String ass[] = ar.get(j).toString().split("=");
                jj.InsertAlarm(new String[]{ud, ass[0], ass[1], ass[2]});
            }
            for (int j = 0; j < ar.size(); j++) {
                String ass[] = ar.get(j).toString().split("=");
                bb.insertData("insert into alarm values('" + ass[0] + "','" + ass[1] + "','" + ass[2] + "')");
            }
            //bb.close();

            
//            // ------------  NOTES  -------------
//            
//            
            ar.clear();
//            bb.open();
            rs = bb.getData("select * from notes");

            while (rs.next()) {
                ar.add(rs.getString("note_id").toString() + "=" + rs.getString("note_date").toString() + "=" + rs.getString("note_data").toString());
            }
            tt = jj.getNotes(ud);

            for (int i = 0; i < tt.length; i++) {
                if (!ar.contains(tt[i].get("note_id"))) {
                    ar.add(tt[i].get("note_id") + "=" + tt[i].get("note_date") + "=" + tt[i].get("note_data"));
                }
            }
            bb.insertData("delete from notes");
            for (int j = 0; j < tt.length; j++) {
                jj.deleteNotes(new String[]{ud, tt[j].get("note_id").toString()});
            }
            for (int j = 0; j < ar.size(); j++) {
                String ass[] = ar.get(j).toString().split("=");
                jj.InsertNotes(new String[]{ud, ass[0], ass[1], ass[2]});
            }
            for (int j = 0; j < ar.size(); j++) {
                String ass[] = ar.get(j).toString().split("=");
                bb.insertData("insert into notes values('" + ass[0] + "','" + ass[1] + "','" + ass[2] + "')");
            }
            //bb.close();

//            // ------------  REMINDER  -------------
//            
//            
            ar.clear();
//            bb.open();
            rs = bb.getData("select * from reminder");

            while (rs.next()) {
                ar.add(rs.getString("remind_id").toString() + "=" + rs.getString("remind_date").toString() + "=" + rs.getString("remind_time").toString()+ "=" + rs.getString("remind_text").toString());
            }
            tt = jj.getRem(ud);

            for (int i = 0; i < tt.length; i++) {
                //System.out.println(ar.get(i)+"...."+tt[i].get("rem_id"));
                if (!ar.contains(tt[i].get("rem_id"))) {
                    ar.add(tt[i].get("rem_id") + "=" + tt[i].get("reminder_date") + "=" + tt[i].get("reminder_time") + "=" + tt[i].get("reminder_text"));
                }
            }
            bb.insertData("delete from reminder");
            for (int j = 0; j < tt.length; j++) {
                jj.deleteRem(new String[]{ud, tt[j].get("rem_id").toString()});
            }
            for (int j = 0; j < ar.size(); j++) {
                String ass[] = ar.get(j).toString().split("=");
                jj.InsertRem(new String[]{ud, ass[0], ass[1], ass[2], ass[3]});
            }
            for (int j = 0; j < ar.size(); j++) {
                String ass[] = ar.get(j).toString().split("=");
                bb.insertData("insert into reminder values('" + ass[0] + "','" + ass[1] + "','" + ass[2]  + "','" + ass[3] + "')");
            }
            bb.close();            
            

        } catch (Exception ex) {
            Logger.getLogger(Sync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {

        try {
            while (true) {
                
                 JSONObject us = jj.getUser(email);
                if(us.get("sync").toString().equals("1")){
                
                DB bb = new DB(ud);
                
                // ----- ALARM --------
                bb.open();
                bb.insertData("delete from alarm");
                JSONObject tt[] = jj.getAlarm(ud);
                for (int j = 0; j < tt.length; j++) {
                    bb.insertData("insert into alarm values('" + tt[j].get("alarm_id").toString() + "','" + tt[j].get("alarm_time").toString() + "','" + tt[j].get("alarm_text").toString() + "')");
                }
//                bb.close();
                
                //  --------  NOTES  ---------
//                
//                bb.open();
                bb.insertData("delete from notes");
                tt = jj.getNotes(ud);
                for (int j = 0; j < tt.length; j++) {
                    bb.insertData("insert into notes values('" + tt[j].get("note_id").toString() + "','" + tt[j].get("note_date").toString() + "','" + tt[j].get("note_data").toString() + "')");
                }
                //bb.close();
                
                //  ----------  REMINDER  ------------
                  //bb.open();
                bb.insertData("delete from reminder");
                tt = jj.getRem(ud);
                for (int j = 0; j < tt.length; j++) {
                    bb.insertData("insert into reminder values('" + tt[j].get("rem_id").toString() + "','" + tt[j].get("reminder_date").toString() + "','" + tt[j].get("reminder_time").toString() + "','" + tt[j].get("reminder_text").toString() + "')");
                }
                bb.close();
                
                         //notification
                 tt=jj.getHistory(ud);
                  for (int j = 0; j < tt.length; j++) {
                      
                      
                      
                    Noti nn=new Noti();
                    nn.dt.setText(tt[j].get("pref_id").toString());
                    
                    String b="";
                    
                    if(tt[j].get("pref_para").toString().split("=")[0].equalsIgnoreCase("c"))
                    {
                        nn.head.setText("Incoming Call...");
                        b="Incoming Call...";
                        nn.img.setIcon(new ImageIcon("assets/dialer.png"));
                    }
                    else
                    {
                            nn.head.setText("Notification...");
                            b="Notification...";
                            nn.img.setIcon(new ImageIcon("assets/bell.ico"));
                    }
                    nn.text.setText(tt[j].get("pref_para").toString().split("=")[1]);
                    nn.dev.setText(tt[j].get("pref_para").toString().split("=")[2]);
                    jj.deleteHistory(tt[0].get("id").toString());
                    
                    if (SystemTray.isSupported()) {
          
                        displayTray(tt[j].get("pref_para").toString().split("=")[1],b);
                                         } else {
                          System.err.println("System tray not supported!");
                                             }
                    
                   //  nn.setVisible(true);
                  }
                  
                 
                  
                  
                  
                  
                  
                
                }
                
                
       
               
                
                
                
                
                
                Thread.sleep(15000);
            }
        } catch (Exception ex) {
            Logger.getLogger(Sync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void displayTray(String a,String b) throws AWTException, MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        java.awt.Image image = Toolkit.getDefaultToolkit().createImage("assets/bell.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray");
       tray.add(trayIcon);

        trayIcon.displayMessage(b, a, MessageType.INFO);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sync.class.getName()).log(Level.SEVERE, null, ex);
        }
        tray.remove(trayIcon);
    }
    
    
}
