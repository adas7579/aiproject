/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author aNaWorLd
 */
public class Greetings {
DateFormat dateFormat = new SimpleDateFormat("HH");
Date date = new Date();

String ori="";
int i=0;


public String greet(String a)
{
    
  i=LocalDateTime.now().getHour();
              
                if(i<12)
                    ori="morning";
                else if(i>12 && i<16)
                    ori=" afternoon";
                else if(i>16)
                    ori="evening";
                
    
    

      System.out.println("Current Hour is : "+i);
    if(a.contains("good")&&a.contains("night"))
        return "Good Night";
    else{
        if(a.contains("good")&&a.contains("morning"))
        {
            if(a.contains(ori))
                return "Good Morning";
            else
                return "its Good "+ori+", actually";
        }
        else if(a.contains("good")&&a.contains("afternoon"))
        {
            if(a.contains(ori))
                return "Good Afternoon";
            else
                return "its Good "+ori+", actually";
        }
         if(a.contains("good")&&a.contains("evening"))
        {
            if(a.contains(ori))
                return "Good Evening";
            else
                return "its Good "+ori+", actually";
        }
    }
    return "";
}}
    

