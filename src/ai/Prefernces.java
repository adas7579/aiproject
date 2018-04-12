/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author aNaWorLd
 */
public class Prefernces {
    
    public ArrayList list=new ArrayList();
    
    void Read()
    {
     try {
                FileReader fr = new FileReader("assets/prefer.txt");
                BufferedReader br = new BufferedReader(fr);
                String s, s1 = "";

                while ((s = br.readLine()) != null) {
                    list.add(s);
                }
              
                br.close();
                fr.close();
            } catch (Exception ex) {
            }
 
     
    }
//    void show(){
//    for(int i=0;i<list.size();i++)
//        System.out.println(list.get(i));
//    }
    void Write()
    {
        try {
                FileWriter fw = new FileWriter("assets/prefer.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                for(int i=0;i<list.size();i++)
                pw.println(list.get(i));
                pw.close();
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
    }
    
}
