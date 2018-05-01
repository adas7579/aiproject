package Games;

import java.io.IOException;
import java.util.*;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sourceforge.javaflacencoder.FLACFileWriter;

public class AudRecog implements GSpeechResponseListener {

    AudPlay njf;

    int cn = 0;
    ArrayList<String> ar = new ArrayList<>();

    public AudRecog(AudPlay nj) {
        njf = nj;
    }

    public AudRecog(NewJFrame nj) {

    }
    final Microphone mic = new Microphone(FLACFileWriter.FLAC);
    //Don't use the below google api key , make your own !!! :) 
    GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");

    public void Reco() throws Exception {

        duplex.setLanguage("en");

        new Thread(() -> {
            try {
                duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }).start();

//		
//				mic.close();
//				duplex.stopSpeechRecognition();
        duplex.addResponseListener(new GSpeechResponseListener() {
            String old_text = "";

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

                System.out.println(output);

                if (gr.isFinalResponse()) {
                    if (output.toLowerCase().equals("play")) {
                        njf.ply.doClick();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().contains("pause") || output.toLowerCase().contains("resume")) {
                        njf.pau.doClick();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().contains("next")) {
                        njf.stp2.doClick();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().contains("previous")) {
                        njf.stp1.doClick();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().contains("stop")) {
                        njf.stp.doClick();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().contains("add song")) {
                        njf.add.doClick();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().contains("remove song")) {
                        njf.rem.doClick();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().equalsIgnoreCase("volume up")) {

                        njf.vol.setValue(njf.vol.getValue() + 10);
                        njf.response.setText(output);
                    } else if (output.toLowerCase().equalsIgnoreCase("volume down")) {
                        njf.vol.setValue(njf.vol.getValue() - 10);
                        njf.response.setText(output);
                    } else if (output.toLowerCase().equals("mute")) {
                        njf.mute();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().equals("unmute")) {
                        njf.mute();
                        njf.response.setText(output);
                    } else if (output.toLowerCase().equals("exit")) {
                        njf.setVisible(false);
                        njf.response.setText(output);
                    } else if (output.toLowerCase().contains("volume")) {
                        String sp[] = output.split(" ");
                        for (String vol : sp) {
                            if (vol.contains("%")) {
                                int v = Integer.parseInt(vol.replace("%", ""));
                                System.out.println(vol + " Volume: " + v);
                                njf.vol.setValue(v);
                            }
                        }
                    } else if (output.toLowerCase().contains("play")) {
                        String sen = output;
                        String key[] = sen.split(" ");
                           
                        for (int i = 0; i < njf.list.getRowCount(); i++) {
                            String song = njf.list.getValueAt(i, 0).toString();
                            System.out.println(song+"<<<<<<<<");
                            for (String k : key) {
                                if (song.toLowerCase().contains(k.toLowerCase())) {
                                     System.out.println("true");
                                    njf.list.setRowSelectionInterval(0, i);
                                    njf.ppy();
                                }
                            }
                        }
                    }

                    op = "";
                    op += this.old_text;
                    op += output;
                }
            }

        });

    }

    @Override
    public void onResponse(GoogleResponse paramGoogleResponse) {
        // TODO Auto-generated method stub
    }

    public void Stop() {
        mic.close();
        duplex.stopSpeechRecognition();
    }
}
