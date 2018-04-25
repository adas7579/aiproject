package ai;

import java.io.*;
import java.sql.ResultSet;
import java.time.*;
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

    int h, m, dd, mm, yy;
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
                    al1.add(rs.getString("remind_date") + "=" + rs.getString("remind_time") + "=" + rs.getString("remind_text"));
                }
                bb.close();
                h = LocalTime.now().getHour();
                m = LocalTime.now().getMinute();
                dd = LocalDate.now().getDayOfMonth();
                mm = LocalDate.now().getMonthValue();
                yy = LocalDate.now().getYear();

                int i = 0;
                while (i < al1.size()) {
                    int dd1 = Integer.parseInt(al1.get(i).toString().split("=")[0].split("/")[0]);
                    int mm1 = Integer.parseInt(al1.get(i).toString().split("=")[0].split("/")[1]);
                    int yy1 = Integer.parseInt(al1.get(i).toString().split("=")[0].split("/")[2]);
                    int h1 = Integer.parseInt(al1.get(i).toString().split("=")[1].split(":")[0]);
                    int m1 = Integer.parseInt(al1.get(i).toString().split("=")[1].split(":")[1]);

                    if (dd == dd1 && mm == mm1 && yy == yy1 && h == h1 && m == m1) {

                        remind a;
                        ring();
                        a = new remind(al1.get(i).toString().split("=")[2], clip);
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
