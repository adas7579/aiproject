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

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public String[] dec(String db) {
        try {
            RSA r = new RSA();
            DB bb = new DB(db);
            bb.open();
            ResultSet rs = bb.getData("select * from login");

            rs.next();
            String s[] = new String[3];
            s[0] = r.Decode(rs.getString("id"), 77, 221);
            s[1] = r.Decode(rs.getString("pwd"), 77, 221);
            s[2] = r.Decode(rs.getString("did"), 77, 221);
            System.out.println("Pre-Credentials: " + s[0] + " " + s[1] + " " + s[2] + "\n\n");
            bb.close();
            return s;

        } catch (Exception ex) {
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
            
        } catch (Exception ex) {
        }
    }
}
