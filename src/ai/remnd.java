package ai;

import java.io.*;
import java.time.LocalDate;
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

    FileReader fr;
    int h, m;

    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    Clip clip;

    public void run() {
        try {

            while (true) {

                fr = new FileReader("assets/reminder.txt");
                BufferedReader br = new BufferedReader(fr);

                String s;
                int fl = 0;

                h = java.time.LocalTime.now().getHour();
                m = java.time.LocalTime.now().getMinute();

//                int d, mm, y;
//                d = LocalDate.now().getDayOfMonth();
//                mm = LocalDate.now().getMonthValue();
//                y = LocalDate.now().getYear();
//                String dt = d + "/" + mm + "/" + y;

                while ((s = br.readLine()) != null) {
                    if (s.contains(h + ":" + m)) {
                        remind a;
                        ring();

                        a = new remind(s.substring(s.lastIndexOf("=") + 1), clip);
                        a.setVisible(true);

                        fl = 1;
                        Thread.sleep(10000);
                        a.setVisible(false);
                        clip.stop();
                    }
                }
                br.close();
                fr.close();

                if (fl == 1) {
                    remove(h, m);
                }

                Thread.sleep(1000);
            }
        } catch (Exception ex) {
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

    public void remove(int h, int m) throws Exception {
        FileReader fr = new FileReader("assets/reminder.txt");
        BufferedReader br = new BufferedReader(fr);
        String s, s1 = "";

        while ((s = br.readLine()) != null) {
            if (!s.contains(h + ":" + m)) {
                s1 += s + "\r\n";
            }
        }
        br.close();
        fr.close();

        PrintWriter pw = new PrintWriter("assets/reminder.txt");
        pw.print(s1);
        pw.close();
    }
}
