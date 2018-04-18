package ai;

import java.io.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author VISION
 */
public class remnd extends Thread {

    int h, m;
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    Clip clip;
    String uid;

    public remnd(String ud) {
        uid = ud;
    }

    public void run() {
        try {
            while (true) {

                DB bb = new DB(uid);
                bb.open();
                ArrayList al1 = new ArrayList();
                ResultSet rs = bb.getData("select * from reminder");
                while (rs.next()) {
                    al1.add(rs.getString("remind_time") + "=" + rs.getString("remind_text"));
                }
                bb.close();
                h = java.time.LocalTime.now().getHour();
                m = java.time.LocalTime.now().getMinute();

                int i = 0;
                while (i < al1.size()) {
                    int h1 = Integer.parseInt(al1.get(i).toString().split("=")[0].split(":")[0]);
                    int m1 = Integer.parseInt(al1.get(i).toString().split("=")[0].split(":")[1]);
                    if (h == h1 && m == m1) {

                        remind a;
                        ring();
                        a = new remind(al1.get(i).toString().split("=")[1], clip);
                        a.setVisible(true);
                        Thread.sleep(10000);
                        a.setVisible(false);
                        clip.stop();
                        Thread.sleep(50000);
                    }
                    i++;
                }
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void ring() {
        try {
            File yourFile = new File("assets/notitone.wav");

            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        } catch (Exception ex) {
        }
    }
}
