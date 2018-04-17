package ai;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONObject;

public class Windows{

    String exe[];
    
    String word[];
    ArrayList ar = new ArrayList();

    ArrayList folder = new ArrayList();
    ArrayList audio = new ArrayList();
    ArrayList video = new ArrayList();
    ArrayList movies = new ArrayList();
    ArrayList browse = new ArrayList();
    ArrayList apps = new ArrayList();
    String sync = "", email;
    JMake jj = new JMake();

    public Windows() {

//System.out.println(email+">>>>>>>>>>>>>>>>test<<<<<<<<<<<<<<<<<<<");
        exe = new String[]{
            "calc.exe",
            "ckhdsk.exe",
            "cleanmgr.exe",
            "start cmd.exe",
            "colorcpl.exe",
            "compmgmtlauncher.exe",
            "control.exe",
            "cttune.exe",
            "defrag.exe",
            "diskpart.exe",
            "dxcpl.exe",
            "dxdiag.exe",
            "eventvwr.exe",
            "fsquirt.exe",
            "lpksetup.exe",
            "magnify",
            "msconfig.exe",
            "mspaint.exe",
            "msra.exe",
            "mstsc.exe",
            "narrator.exe",
            "optionalfeature.exe",
            "osk.exe",
            "regedt32.exe",
            "resmon.exe",
            "rstrui.exe",
            "sdclt.exe",
            "SndVol.exe",
            "snippingtool.exe",
            "stickynot.exe",
            "Taskmgr.exe",
            "UserAccountControlSettings.exe",
            "utilman.exe",
            "winver.exe",
            "write.exe",
            "wuauclt.exe",
            "xpsrchvw.exe",
            "explorer.exe",
            "notepad.exe",
            "chrome.exe"};

        word = new String[]{
            "calculator",
            "check disk checker",
            "disk cleanup",
            "command prompt cmd",
            "colour control",
            "computer management",
            "control panel",
            "clear type tuner",
            "disk defragmenter defragmentation",
            "diskpart",
            "direct x control",
            "direct x diagnostic tool",
            "event viewer",
            "bluetooth",
            "language package intaller",
            "magnifier",
            "system configuration utllity",
            "paint",
            "remote assistant",
            "remote desktop connection",
            "narrator",
            "windows feature",
            "on screen keyboard",
            "system registry regedit",
            "resource monitor",
            "system restore point",
            "windows backup and restore",
            "volume mixer",
            "snipping tools",
            "sticky notes",
            "task manager",
            "user account control setting uac",
            "ease of access",
            "windows version",
            "wordpad",
            "windows update",
            "xps viewer",
            "my computer pc",
            "notepad",
            "google chrome web browser"
        };

        getFav1();
    }
    String fname;
    String pth = "";

    private void getFav1() {
        try {
            FileReader fr = new FileReader("assets/fav/folder.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                folder.add(a[1]);
            }
            br.close();
            fr.close();

            fr = new FileReader("assets/fav/audio.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                audio.add(a[1]);
            }
            br.close();
            fr.close();

            fr = new FileReader("assets/fav/video.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                video.add(a[1]);
            }
            br.close();
            fr.close();

            fr = new FileReader("assets/fav/movies.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                movies.add(a[1]);
            }

            br.close();
            fr.close();

            fr = new FileReader("assets/fav/apps.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                String a[] = s.split("=");
                apps.add(a[1]);
            }
            br.close();
            fr.close();

            fr = new FileReader("assets/fav/browse.txt");
            br = new BufferedReader(fr);
            s = "";
            while ((s = br.readLine()) != null) {
                browse.add(s);
            }
            br.close();
            fr.close();

        } catch (Exception e) {
        }

        System.out.println(folder);
        System.out.println(audio);
        System.out.println(video);
        System.out.println(movies);
        System.out.println(browse);
        System.out.println(apps);
    }

    public String search(String fn) {
        //C:\Users\aNaWorLd\AppData\Roaming\Microsoft\Windows\Recent
       
        fname = fn;
        pth = "";
        // direc("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Recent");
        // direc(fn);
        file("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Recent");
        //file("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Recent");
        apps("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs");
        apps("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs");
        //System.out.println("C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\Microsoft\\Windows\\Recent");
        return pth;
    }

    private void file(String path) {

        File root = new File(path);
        File[] list = root.listFiles();

        for (File f : list) {
            if (f.isFile() && f.getName().toLowerCase().contains(fname.toLowerCase())) {
                try {
                    WindowsShortcut ws = new WindowsShortcut(f);
                    if (ws.isDirectory()) {
                        ar.add(f.getName() + "=Folder=explorer \"" + f.getPath() + "\"");
                    } else {
                        if(ws.getRealFilename().contains("."))
                        ar.add(f.getName() + "=File=\"" + ws.getRealFilename() + "\"");
                    }
                    pth = "\"" + ws.getRealFilename() + "\"";
                } catch (Exception ex) {
                }
            } else if (f.isDirectory()) {
                file(f.getAbsolutePath());
            }

        }
    }

    private void direc(String dir) {
        File r = new File(dir);
        File[] l = r.listFiles();

        for (File f : l) {
            if (f.isFile() && !f.getName().contains("desktop.ini") && !f.getName().contains("Thumbs.db")) {
                // System.out.println(f.getAbsolutePath());
                if(f.getAbsolutePath().contains("."))
                ar.add(f.getName() + "=File=\"" + f.getAbsolutePath() + "\"");
            }
            if (f.isDirectory()) {
                direc(f.getAbsolutePath());
            }
        }
    }

    private void apps(String path) {

        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) {
            return;
        }
        for (File f : list) {

            if (f.getName().toLowerCase().contains(fname.toLowerCase()) && f.getName().contains(".lnk")) {
                try {

                    WindowsShortcut ws = new WindowsShortcut(f);
                    System.out.println(ws.getRealFilename());
                    pth = "\"" + ws.getRealFilename() + "\"";
                    String g = f.getName();
                    //System.out.println(pth);
                    if (f.getName().endsWith(".lnk")) {
                        g = g.substring(0, g.length() - 4);
                    }
                       if(ws.getRealFilename().contains("."))
                    ar.add(g + "=App=\"" + ws.getRealFilename() + "\"");
                } catch (Exception ex) {
                }
            } else if (f.isDirectory()) {
                System.out.println(f.getName());
                if (!f.getName().contains("Accessories")) {
                    apps(f.getAbsolutePath());
                }
            }
        }
    }

    public String[] pr(String cmd) {

        if (cmd.toLowerCase().contains("open")) {
            cmd = cmd.trim().substring(5);

            return excom(cmd);
        } else if (cmd.toLowerCase().contains("calculate")) {

            String ss[] = new String[2];
            cmd = cmd.replace("X", "*");
            cmd = cmd.replace("into", "*");
            cmd = cmd.replace("x", "*");
            NewClass nc = new NewClass();
            cmd = cmd.substring(cmd.indexOf(" ") + 1);
            cmd = cmd.replace(" ", "");
            String d = "";
            for (int i = 0; i < cmd.length(); i++) {
                char ch = cmd.charAt(i);
                if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '(' || ch == ')') {
                    d = d + " " + ch + " ";
                } else {
                    d = d + ch;
                }
            }
            System.out.println("?????????????????????????????  " + d);
            ss[1] = String.valueOf(nc.evaluate(d));
            ss[0] = "@#$";
            return ss;
            //System.out.println(line);

        } else if (cmd.toLowerCase().contains("set") && cmd.toLowerCase().contains("alarm")) {
            return setalarm(cmd);
        } else if ((cmd.toLowerCase().contains("show") && cmd.toLowerCase().contains("alarm"))||(cmd.toLowerCase().contains("delete") && cmd.toLowerCase().contains("alarm"))) {
            viewalm v = new viewalm(uid, email);
            v.setVisible(true);
            String ss[] = new String[2];
            ss[0] = "@#$";
            ss[1] = "Here are your alarms.";
            return ss;
        } else if (cmd.toLowerCase().contains("remind me to")) {
            return setreminder(cmd);
        } else if (cmd.toLowerCase().contains("show") && cmd.toLowerCase().contains("reminder")) {
            viewremind v = new viewremind();
            v.setVisible(true);
            String ss[] = new String[2];
            ss[0] = "@#$";
            ss[1] = "Here are your reminders.";
            return ss;
        } else if (cmd.toLowerCase().contains("music") || cmd.toLowerCase().contains("song") || cmd.toLowerCase().contains("audio") || cmd.toLowerCase().contains("play")) {
            // show music abcd2
            ar.clear();
            String cm = cmd;
            String tem[] = new String[]{"open", "show", "display", "play", "music", "song", "songs", "audio"};
            for (String aa : tem) {
                cm = cm.replace(aa, "");
            }
            cm = cm.trim();
            //fname=cm;
            for (int i = 0; i < audio.size(); i++) {
                //  System.out.println(audio.get(i).toString());
                direc(audio.get(i).toString());
            }
            for (int i = 0; i < video.size(); i++) {
                //  System.out.println(audio.get(i).toString());
                direc(video.get(i).toString());
            }
            ArrayList asd = new ArrayList();
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).toString().split("=")[0].toLowerCase().contains(cm.toLowerCase())) {
                    asd.add(ar.get(i));
                }
            }

            if (asd.size() > 1) {
                Options op = new Options(asd);
                op.setVisible(true);

                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "Here is a list of your favorite audio files.";
                return ss;
            } else {
                String ss[] = new String[2];
                String as = asd.get(0).toString();
                ss[0] = as.substring(as.lastIndexOf("=") + 1);
                ss[1] = cm;
                return ss;
            }
        } else if (cmd.toLowerCase().contains("document") || cmd.toLowerCase().contains("file")) {
            ar.clear();
            String cm = cmd;
            String tem[] = new String[]{"open", "show", "display", "file", "document"};
            for (String aa : tem) {
                cm = cm.replace(aa, "");
            }
            cm = cm.trim();
            for (int i = 0; i < folder.size(); i++) {
                //  System.out.println(audio.get(i).toString());
                direc(folder.get(i).toString());
            }

            ArrayList asd = new ArrayList();
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).toString().split("=")[0].toLowerCase().contains(cm.toLowerCase())) {
                    asd.add(ar.get(i));
                    System.out.println(ar.get(i));
                }
            }

            if (asd.size() > 1) {
                Options op = new Options(asd);
                op.setVisible(true);

                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "Here is a list of your favorite documents files.";
                return ss;
            } else if (asd.size() == 1) {
                String ss[] = new String[2];
                String as = asd.get(0).toString();
                ss[0] = as.substring(as.lastIndexOf("=") + 1);
                ss[1] = cm;
                return ss;
            } else {
                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "I didn't find any match!";
                return ss;
            }
        } else if (cmd.toLowerCase().contains("movie") || cmd.toLowerCase().contains("film") || cmd.toLowerCase().contains("video")) {
            ar.clear();
            String cm = cmd;
            String tem[] = new String[]{"open", "show", "display", "film", "movie", "video"};
            for (String aa : tem) {
                cm = cm.replace(aa, "");
            }
            cm = cm.trim();
            for (int i = 0; i < movies.size(); i++) {
                //  System.out.println(audio.get(i).toString());
                direc(movies.get(i).toString());
            }
            for (int i = 0; i < video.size(); i++) {
                //  System.out.println(audio.get(i).toString());
                direc(video.get(i).toString());
            }

            System.out.println(ar + ">>>>>>>>" + video);

            ArrayList asd = new ArrayList();
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).toString().split("=")[0].toLowerCase().contains(cm.toLowerCase())) {
                    asd.add(ar.get(i));
                }
            }

            if (asd.size() > 1) {
                Options op = new Options(asd);
                op.setVisible(true);

                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "Here is a list of your favorite movies.";
                return ss;
            } else if (asd.size() == 1) {
                String ss[] = new String[2];
                String as = asd.get(0).toString();
                ss[0] = as.substring(as.lastIndexOf("=") + 1);
                ss[1] = cm;
                return ss;
            } else {
                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "I didn't find any match!";
                return ss;
            }
        } else if (cmd.toLowerCase().contains("app") || cmd.toLowerCase().contains("application") || cmd.toLowerCase().contains("software")) {
            ar.clear();
            String cm = cmd;
            String tem[] = new String[]{"open", "show", "display", "file", "document", "app", "apps", "application", "software"};
            for (String aa : tem) {
                cm = cm.replace(aa, "");
            }
            cm = cm.trim();
            for (int i = 0; i < apps.size(); i++) {
                //  System.out.println(audio.get(i).toString());
                direc(apps.get(i).toString());
            }

            System.out.println(ar + ">>>>>>>>" + apps);

            ArrayList asd = new ArrayList();
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).toString().split("=")[0].toLowerCase().contains(cm.toLowerCase())) {
                    asd.add(ar.get(i));
                }
            }

            if (asd.size() > 1) {
                Options op = new Options(asd);
                op.setVisible(true);

                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "Here is a list of your favorite apps.";
                return ss;
            } else if (asd.size() == 1) {
                String ss[] = new String[2];
                String as = asd.get(0).toString();
                ss[0] = as.substring(as.lastIndexOf("=") + 1);
                ss[1] = cm;
                return ss;
            } else {
                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "I didn't find any match!";
                return ss;
            }
        } else if (cmd.toLowerCase().contains("web") || cmd.toLowerCase().contains("url") || cmd.toLowerCase().contains("browse") || cmd.toLowerCase().contains("internet")) {
            ar.clear();
            String cm = cmd;
            String tem[] = new String[]{"open", "web", "url", "browse", "internet"};
            for (String aa : tem) {
                cm = cm.replace(aa, "");
            }
            cm = cm.trim();
            for (int i = 0; i < browse.size(); i++) {
                if (browse.get(i).toString().split("`")[0].toLowerCase().contains(cm.toLowerCase())) {
                    System.out.println(browse.get(i).toString().split("`")[0] + "`Website`" + browse.get(i).toString().split("`")[1]);
                    ar.add(browse.get(i).toString().split("`")[0] + "`Website`" + browse.get(i).toString().split("`")[1]);
                }
            }

            if (ar.size() > 1) {
                Options op = new Options(ar);
                op.setVisible(true);

                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "Here is a list of your favorite Websites.";
                return ss;
            } else if (ar.size() == 1) {
                try {
                    System.out.println(ar);
                    //    Desktop.getDesktop().browse(new URI(ar.get(0).toString().split("`")[1]));
                    Desktop.getDesktop().browse(new URI(ar.get(0).toString().split("`")[2]));

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "Here is your matching Website.";
                return ss;
            } else {
                String ss[] = new String[2];
                ss[0] = "@#$";
                ss[1] = "No matching websites found!";
                return ss;
            }

        } else {
            return excom(cmd);

        }
    }

    public String uid;

    public void writeRemind(String dt, String h, String m, String msg) {
        try {
            Instant in = Instant.now();
            String js[] = {uid, in.toString(), dt, h + ":" + m, msg};
            jj.InsertRem(js);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void writeAlarm(String hm, String msg) {
        try {
            DB bb = new DB(uid);
            bb.open();
            Instant in = Instant.now();
            bb.insertData("insert into alarm values('" + in.toString() + "','" + (hm) + "','" + msg + "')");
            bb.close();
            JSONObject tt = jj.getUser(email);
            sync = tt.get("sync").toString();
            if (sync.equals("1")) {
                String js[] = {uid, in.toString(), hm, msg};
                jj.InsertAlarm(js);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String[] setalarm(String cmd) {
        try {
            String parts[] = cmd.split(" ");
            String da = "", ap = "";
            if (cmd.contains("alarm")) {
                int t = -1;
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].contains(":")) {
                        t = i;
                    }
                }
                if (t != -1) {
                    SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
                    Date d = null;

                    d = sdf.parse(parts[t]);
                    if (parts.length > t + 1) {
                        da = "" + d.getHours();
                        int n = Integer.parseInt(da);
                        if ((cmd.toLowerCase().contains("pm") || cmd.toLowerCase().contains("p.m") || cmd.toLowerCase().contains("p.m.")) && n < 13) {
                            n += 12;
                            if (n >= 24) {
                                n -= 12;
                            }
                            ap = "PM";
                        } else if ((cmd.toLowerCase().contains("am") || cmd.toLowerCase().contains("a.m") || cmd.toLowerCase().contains("a.m.")) && n > 11) {
                            n -= 12;
                            ap = "AM";
                        }
                        da = n + ":" + d.getMinutes();
                    }
                }
            }
            writeAlarm(da.trim(), "Wake up time!");
            String ss[] = new String[2];

            ss[0] = "@#$";
            ss[1] = "Ok, the alarm is set.";

            return ss;
        } catch (Exception ex) {
            String ss[] = new String[2];
            ss[0] = "@#$";
            ss[1] = "Sorry, I didn't understand";
        }
        return null;
    }

    public String[] setreminder(String cmd) {
        // Remind me to buy groceries at 7:00 P.M tomorrow
        String[] s = cmd.split(" ");
        int i = 0, j;
        String ss = "";

        while (!s[i].equalsIgnoreCase("to")) {
            i++;
        }
        i++;

        for (j = i; j < s.length; j++) {
            if (!s[j].equalsIgnoreCase("at")) {
                ss += s[j] + " ";
            } else {
                break;
            }
        }
        String dat = "";
        for (int k = j + 4; k < s.length; k++) {
            dat += s[k];
        }

        //System.out.println(s[j + 1] + " " + s[j + 2]);
        int hh = Integer.parseInt(s[j + 1].split(":")[0]), mm;
        if (s[j + 1].contains(":")) {
            mm = Integer.parseInt(s[j + 1].split(":")[1]);
        } else {
            mm = 0;
        }
        String nn = s[j + 2];
        String t[] = new String[2];
        if (hh < 12 && nn.toUpperCase().contains("P.M")) {
            t[0] = String.valueOf(hh + 12);//hh = hh + 12;
        } else if (hh == 12 && nn.toUpperCase().contains("A.M")) {
            t[0] = String.valueOf("00");//hh = 0;
        }

        if (Integer.parseInt(t[0]) < 10 && !t[0].startsWith("0")) {
            t[0] = "0" + t[0];
        }
        if (Integer.parseInt(t[1]) < 10 && !t[1].startsWith("0")) {
            t[1] = "0" + t[1];
        }
        System.out.println(t[0] + " " + t[1]);
        String dt = "";
        int d, mmm, y;
        d = LocalDate.now().getDayOfMonth();
        mmm = LocalDate.now().getMonthValue();
        y = LocalDate.now().getYear();
        dt = d + "/" + mmm + "/" + y;

        if (cmd.toLowerCase().contains("tomorrow")) {
            LocalDate dd = LocalDate.now().plusDays(1);
            d = dd.getDayOfMonth();
            mmm = dd.getMonthValue();
            y = dd.getYear();
            dt = d + "/" + mmm + "/" + y;
        }

        LocalTime ct = LocalTime.now();
        String msg = ss;
        if (t[1].equals("00")) {
            if (ct.compareTo(LocalTime.parse(t[0] + ":" + t[1])) > 0) {
                LocalDate dd = LocalDate.now().plusDays(1);
                d = dd.getDayOfMonth();
                mm = dd.getMonthValue();
                y = dd.getYear();
                dt = d + "/" + mm + "/" + y;
            }

            writeRemind(dt, t[0], "00", msg);
        } else {
            if (ct.compareTo(LocalTime.parse(t[0] + ":" + t[1])) > 0) {
                LocalDate dd = LocalDate.now().plusDays(1);
                d = dd.getDayOfMonth();
                mm = dd.getMonthValue();
                y = dd.getYear();
                dt = d + "/" + mm + "/" + y;
            }

            writeRemind(dt, t[0], t[1], msg);
        }

        String ss1[] = new String[2];
        ss1[0] = "@#$";
        ss1[1] = "Got it. I will remind you about that.";

        return ss1;
    }

    public String[] excom(String cmd) {
        String a[] = cmd.split(" ");
        int hits[] = new int[40];
        int max = 0, in = 0;
        for (int i = 0; i < word.length; i++) {
            String ww = word[i];
            int t = 0;
            for (int j = 0; j < a.length; j++) {
                if (ww.contains(a[j].toLowerCase())) {
                    t++;
                }
            }
            hits[i] = t;
            if (t > max) {
                max = t;
                in = i;
            }
        }
        int cn = 0;
        if (max > 0) {
            for (int i = 0; i < hits.length; i++) {
                if (hits[i] == max) {
                    ar.add(word[i] + "=App=" + exe[i]);
                    cn++;
                }
            }
        }

        String ph = search(cmd);
        System.out.println(ar);

        if (ar.size() == 1) {
            String ok[] = new String[2];
            ok[0] = exe[in];
            ok[1] = cmd;
            if (max > 0) {
                ar.clear();
                return ok;
            }
            //String ph = search(cmd);

            ok[0] = ph;
            ok[1] = cmd;
            ar.clear();
            return ok;

        } else if (ar.size() > 1) {
            Options op = new Options(ar);
            op.setVisible(true);
            ar.clear();
            String temp[] = {"@#$", "Here's a list of files and apps with similar names."};
            return temp;
        }
        ar.clear();
        String temp[] = {"@#$", ""};
        return temp;
    }
}

/*

 if (Desktop.isDesktopSupported()) {
                                       try {
                                           Desktop.getDesktop().browse(new URI("http://www.google.com"));
                                       } catch (Exception ex) {
                                       }
                                   }
 */
