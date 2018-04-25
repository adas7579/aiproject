package ai;

import java.util.*;
import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;
import java.awt.Desktop;
import java.net.URI;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.javaflacencoder.FLACFileWriter;
import application.*;
import java.time.Instant;
import org.json.simple.JSONObject;

public class SpRecog implements GSpeechResponseListener {

    test njf;
    Windows w = new Windows();
    public String uid;
    Main ms= null;
    String email,timeStamp, note = "";
    JSONObject detail;
    int cn = 0;
    int nt = 0;
    ArrayList<String> ar = new ArrayList<>();
    Prefernces pp;
    noteedit n;
    notenew nn;
    JMake jj;
    
    public SpRecog(test nj, Prefernces pp, ArrayList con,String uid,String email,JSONObject detail) {
        this.pp = pp;
        njf = nj;
            this.detail=detail;
        this.uid=uid;
        w.uid = uid;
        this.email=email;
       w.email = email;
        System.out.println("\nSprecog\n"+uid);
        n = new noteedit(new String[]{"0","1","2","3"},null);
        nn=new notenew(new String[]{"0","1","2","3"});
        if (con.get(0).toString().split("=")[1].equals("1")) {
            String name = con.get(1).toString().split("=")[1];
            float frq = Float.parseFloat(con.get(2).toString().split("=")[1]) * 0.2f;
            ms = new Main(name, frq);
        }
    }
    final Microphone mic = new Microphone(FLACFileWriter.FLAC);
    //Don't use the below google api key , make your own !!! :) 
    public GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");

    public void Reco() throws Exception {

        duplex.setLanguage("en");

        new Thread(() -> {
            try {
                duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }).start();

//				mic.close();
//				duplex.stopSpeechRecognition();
        duplex.addResponseListener(new GSpeechResponseListener() {
            String old_text = "";
            GoogleResponse gq;

            public void onResponse(GoogleResponse gr) {
                String output = "", op = "";
                output = gr.getResponse();
                if (gr.getResponse() == null) {
                    this.old_text = op;
                    if (this.old_text.contains("(")) {
                        this.old_text = this.old_text.substring(0, this.old_text.indexOf('('));
                    }
                    System.out.println("Paragraph Line Added");
                    this.old_text = (op + "\n");
                    this.old_text = this.old_text.replace(")", "").replace("( ", "");
                    op = this.old_text;
                    return;
                }
                if (output.contains("(")) {
                    output = output.substring(0, output.indexOf('('));
                }
                if (!gr.getOtherPossibleResponses().isEmpty()) {
                    output = output + "(" + (String) gr.getOtherPossibleResponses().get(0) + ")";
                }

                if (output.startsWith(" ")) {
                    output = output.substring(1, output.length());
                }

                njf.response.setText(output);
                if (gr.isFinalResponse()) {
                    njf.close();
                }
                if (gr.isFinalResponse()) {
                    start(output);
                    String vf = output;
                    if (output.contains("open")) {
                        vf = output.substring(4);
                        vf = vf.trim();
                    }
                    pp.list.add(vf);
                    System.out.print(pp.list);
                }
              

                op = "";
                op += this.old_text;
                op += output;
            }
        }
        );
    }
    int sig = 0;

    Greetings grr = new Greetings();

    void start(String output) {

        String aaa = grr.greet(output);
        if (!aaa.equals("")) {
            njf.opt.setText(aaa);
            try {
                ms.sp = njf.opt.getText();
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
            nn.jj=jj;
            nn.user = detail;
            njf.opt.setText("Creating a Note");
            try {
                ms.sp = njf.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            nn.setVisible(true);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            njf.opt.setText("Need assistance?");
            //write(timeStamp);
            return;
        } else if ((output.toLowerCase().equalsIgnoreCase("save it") || output.toLowerCase().equalsIgnoreCase("save note")) && (n.isVisible() == true)) {
            nt = 0;
            write(timeStamp, note);
            njf.opt.setText("Saving a Note");
            try {
                ms.sp = njf.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            nn.setVisible(false);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            njf.opt.setText("Need assistance?");
            //write("----");
            return;
        } else if (output.toLowerCase().contains("show") && output.toLowerCase().contains("note")) {
            nt = 0;
            notes n=new notes(uid,email);
            njf.opt.setText("Showing Notes");
            try {
                ms.sp = njf.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            n.setVisible(true);
             try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            njf.opt.setText("Need assistance?");
            return;
        } else if (output.toLowerCase().contains("close") && output.toLowerCase().contains("note")) {
            njf.opt.setText("Closing Notes");
            try {
                ms.sp = njf.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            n.setVisible(false);
             try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            njf.opt.setText("Need assistance?");
            return;
        } else if (output.equalsIgnoreCase("Listen")) {
            sig = 0;
            return;
        } else if (output.equalsIgnoreCase("discard")) {
            // JOptionPane.showMessageDialog(null, "hello");
            sig = 1;

            njf.response.setText("");
            return;
        } else if (output.equalsIgnoreCase("exit")) {
            njf.opt.setText("Good day!");
            try {
                ms.sp = njf.opt.getText();
                ms.run();
            } catch (Exception e) {
                System.out.println("TTS is Diasabled!");
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
            System.exit(0);
        }

        if (nt == 0) {
            if (sig == 0) {
                String tt[] = w.pr(output);

                if (tt[0] != "@#$") {
                    int ch = execute(tt[0]);
                    if (ch == 0) {
                        njf.opt.setText("Opening " + tt[1] + " ...");
                        try {
                            ms.sp = njf.opt.getText();
                            ms.run();
                        } catch (Exception e) {
                            System.out.println("TTS is Diasabled!");
                        }
                    }
                } else {
                    njf.opt.setText(tt[1]);
                    if (njf.opt.getText() != "") {
                        try {
                            ms.sp = njf.opt.getText();
                            ms.run();
                        } catch (Exception e) {
                            System.out.println("TTS is Diasabled!");
                        }
                    } else {
                        sorry(output);
                    }
                }
            }
        } else {
//            n.ta.append(output + "\r\n");
            note += output + "\r\n";
            njf.response.setText("");
        }
        try {
            Thread.sleep(1000);

        } catch (InterruptedException ex) {
            Logger.getLogger(SpRecog.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        njf.opt.setText("Need assistance?");
        njf.response.setText("");
    }
    Aires ai;
    public void sorry(String a) {
      try {
        JSONObject tt=jj.aiResponse("desktop:"+a);
        Aires ai=new Aires(tt);
        ai.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onResponse(GoogleResponse paramGoogleResponse) {
        // TODO Auto-generated method stub
    }

    public int execute(String e) {
        try {
            if (e.equalsIgnoreCase("chrome.exe")) {
                if (new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe").exists()) {
                    Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                } else if (new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe").exists()) {
                    Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
                } else {
                    njf.opt.setText("Chrome not installed. Opening default web browser...");
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI("http://www.google.com"));
                        } catch (Exception ex) {
                        }
                    }
                    return 1;
                }
            } else {
                Runtime.getRuntime().exec("cmd /c start \"\" " + e);
            }
        } catch (Exception ex) {
        }
        return 0;
    }

    public void Stop() {
        mic.close();
        duplex.stopSpeechRecognition();
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
