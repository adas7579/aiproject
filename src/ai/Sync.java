/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                bb.close();
//                




                }















                Thread.sleep(15000);
            }
        } catch (Exception ex) {
            Logger.getLogger(Sync.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
