/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    Connection connection = null;
    Statement statement;
    ResultSet rs;

    public DB(String db) {

        try {      // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:assets/"+db+".db");
        } catch (Exception e) {
        }
    }

    public void open() {
        try {
            statement = connection.createStatement();
        } catch (Exception ex) {
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception ex) {
        }
    }

    public void insertData(String q) {
        try {
            statement.executeUpdate(q);
        } catch (Exception ex) {System.out.println("\n\n"+ex.getMessage()+"\n\n");
        
        }
    }

    public ResultSet getData(String q) {
        try {
            
            return statement.executeQuery(q);
        } catch (Exception ex) {System.out.println("\n\n"+ex.getMessage()+"\n\n");
        }
        return null;
    }

    public void newuser(String a[]) throws Exception {
        statement.executeUpdate("drop table if exists login");
        statement.executeUpdate("create table login (id string, pwd string,did string)");
        statement.executeUpdate("insert into login values('" + a[0] + "','" + a[1] + "','" + a[2] + "')");

        statement.executeUpdate("drop table if exists alarm");
        statement.executeUpdate("create table alarm (alarm_id string, alarm_time string, alarm_text string)");
        statement.executeUpdate("drop table if exists reminder");
        statement.executeUpdate("create table reminder(remind_id string, remind_date string,remind_time string, remind_text string)");
        statement.executeUpdate("drop table if exists notes");
        statement.executeUpdate("create table notes(note_id string,note_date string,note_data string)");
        statement.executeUpdate("drop table if exists prefer");
        statement.executeUpdate("create table prefer(p string unique)");

        ResultSet rs = statement.executeQuery("select * from login");
        while (rs.next()) {
            System.out.println("email = " + rs.getString("id"));
            System.out.println("paasword = " + rs.getString("pwd"));
            System.out.println("deviceid  = " + rs.getString("did"));
        }

    }
}
