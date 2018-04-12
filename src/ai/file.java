/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.io.File;
import java.io.FileWriter;
import mslinks.*;
/**
 *
 * @author ULTRON
 */
public class file {

    File ff;

    FileWriter fw;
    String ext;
    String dr;
    int sw = 0;

    public file(String d, String ex, int s) {
        dr = d;
        ext = ex;
        sw = s;
    }

    public void search() throws Exception {
        File a[];
        a = File.listRoots();

  
        
        ff = new File("assets/filelist.txt");
        ff.createNewFile();
        fw = new FileWriter(ff);
        System.out.println("Started File Searching...");

        for (int i = 0; i < a.length; i++) {

            if (a[i].getPath().equalsIgnoreCase(dr)) {
                directory(a[i]);
                if (!dr.equals("*")) {
                    break;
                }
            }
        }

        System.out.println("File Searching Finished.");
        fw.close();
    }

    public void directory(File dir) throws Exception {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (sw == 0) {
                if (file.isFile() && file.getName().contains(ext)) {
                    System.out.println(file.getAbsolutePath());
                    fw.write(file.getAbsolutePath() + "\n");
                }
            }
            if (sw == 1) {
                if (file.isDirectory() && file.getName().equalsIgnoreCase(ext)) {
                    System.out.println(file.getPath());
                }
            }
            if (file.listFiles() != null) {
                directory(file);
            }
        }
    }
    
    public void searchAll(File dir)throws Exception
    {
        File[] files = dir.listFiles();
        for (File file : files) {

                if (file.isFile()) {
                    
                    System.out.println(file.getAbsolutePath());
              
                   // fw.write(file.getAbsolutePath() + "\n");
                }
                if (file.isDirectory()) {
                    System.out.println(file.getPath());
                
                }
                
            if (file.listFiles() != null) {
                searchAll(file);
            }
        
    
}
}
}
