package application;

import ai.test;
import marytts.signalproc.effects.JetPilotEffect;
import marytts.signalproc.effects.LpcWhisperiserEffect;
import marytts.signalproc.effects.RobotiserEffect;
import marytts.signalproc.effects.StadiumEffect;
import marytts.signalproc.effects.VocalTractLinearScalerEffect;
import marytts.signalproc.effects.VolumeEffect;
import java.util.*;
public class Main implements Runnable {
	
    public String sp;
    
    String name;float freq;
    public Main()
    {}
    public Main(String name,float freq)
    {
    this.name=name;
    this.freq=freq;
    }
	/**
	 * The main method from which our application is starting
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//            Scanner d=new Scanner(System.in);
//		//Create TextToSpeech
//		TextToSpeech tts = new TextToSpeech();
//                System.out.print("Enter : ");
//                String ss=d.nextLine();
//		//run(ss);
	
		
	}
	
		
		
		
        

     //6.0206
//f2-dfki-poppy-hsmm
        //f1-cmu-slt-hsmm
 //m-cmu-rms-hsmm
    
  
    @Override
    public void run() {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             TextToSpeech tts = new TextToSpeech();
             if(name.equalsIgnoreCase("Male"))
                 name="cmu-rms-hsmm";
             else if(name.equalsIgnoreCase("female 1"))
                 name="cmu-slt-hsmm";
             else if(name.equalsIgnoreCase("female 2"))
                 name="dfki-poppy-hsmm";
                System.out.println(name+"  "+freq);
		//tts.getAvailableVoices().stream().forEach(voice -> System.out.println("Voice: " + voice));
                
		 tts.setVoice(name);
		tts.speak(sp, freq, false, true);              
            }});
    }
        
}
    


