/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

/**
 *
 * @author aNaWorLd
 */
import java.io.*;
import java.sql.ResultSet;

public class remem {

    public void enc(String db, String em, String pss, String dvid) {
        try {
            RSA r = new RSA();
            String etem = r.Encode(em, 5, 221);
            String etpss = r.Encode(pss, 5, 221);
            String etdv = r.Encode(dvid, 5, 221);

            DB bb = new DB(db);
            bb.open();
            bb.newuser(new String[]{etem, etpss, etdv});
            bb.close();

            FileWriter fw = new FileWriter("assets/9x8nb4.dat");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(r.Encode(db, 5, 221));
            pw.close();
            bw.close();
            fw.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public String[] dec() {
        try {
            FileReader fr = new FileReader("assets/9x8nb4.dat");
            BufferedReader br = new BufferedReader(fr);

            RSA r = new RSA();
            String s[] = new String[4];
            s[0] = r.Decode(br.readLine(), 77, 221);

            DB bb = new DB(s[0]);
            bb.open();
            ResultSet rs = bb.getData("select * from login");
            
            rs.next();
    
            s[1] = r.Decode(rs.getString("id"), 77, 221);
        
            s[2] = r.Decode(rs.getString("pwd"), 77, 221);
            s[3] = r.Decode(rs.getString("did"), 77, 221);
            System.out.println("Pre-Credentials: " + s[0] + " " + s[1] + " " + s[2] + "\n\n");
            bb.close();
            br.close();
            fr.close();
            return s;

        } catch (Exception ex) {
            System.out.println("\n\n Reme.java>>>>>>>>:::::::::>.>>\n\n"+ex.getMessage());
        }
        return null;
    }

    public void clear(String db) {
        try {
            DB bb = new DB(db);
            bb.open();
            bb.insertData("drop table if exists login");
            bb.insertData("create table login (id string, pwd string,did string)");
            bb.close();
            FileWriter fw = new FileWriter("assets/9x8nb4.dat");
            fw.close();

        } catch (Exception ex) {
        }
    }
}
