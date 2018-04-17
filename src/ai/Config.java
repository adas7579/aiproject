/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author aNaWorLd
 */
public class Config {

    ArrayList ar=new ArrayList();

    public void read() {
        try {
            FileReader fr = new FileReader("assets/config.cfg");
            BufferedReader br = new BufferedReader(fr);

            String ss = "";
            ar.clear();
            while ((ss = br.readLine()) != null) {
                ar.add(ss);   
            }
            br.close();
            fr.close();
        } catch (Exception ex) {
        }
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter("assets/config.cfg");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String ss = "";
            int i = 0;
            while (i<ar.size()) {
                pw.println(ar.get(i));
                i++;
            }
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception ex) {
        }
    }
}
