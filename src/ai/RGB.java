/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aNaWorLd
 */
public class RGB extends Thread{
    welcome wl;
    public RGB(welcome wl)
    {
    this.wl=wl;
    
    }
    @Override
     public void run()
        {
            while(true){
            if(wl.z1.getForeground()==Color.RED)
               wl.z1.setForeground(Color.GREEN);
           else if(wl.z1.getForeground()==Color.GREEN)
               wl.z1.setForeground(Color.BLUE);
            else if(wl.z1.getForeground()==Color.BLUE)
               wl.z1.setForeground(Color.RED);
            
            if(wl.z2.getForeground()==Color.RED)
               wl.z2.setForeground(Color.GREEN);
           else if(wl.z2.getForeground()==Color.GREEN)
               wl.z2.setForeground(Color.BLUE);
            else if(wl.z2.getForeground()==Color.BLUE)
               wl.z2.setForeground(Color.RED);
            
            if(wl.z3.getForeground()==Color.RED)
               wl.z3.setForeground(Color.GREEN);
           else if(wl.z3.getForeground()==Color.GREEN)
               wl.z3.setForeground(Color.BLUE);
            else if(wl.z3.getForeground()==Color.BLUE)
               wl.z3.setForeground(Color.RED);
            
            if(wl.z4.getForeground()==Color.RED)
               wl.z4.setForeground(Color.GREEN);
           else if(wl.z4.getForeground()==Color.GREEN)
               wl.z4.setForeground(Color.BLUE);
            else if(wl.z4.getForeground()==Color.BLUE)
               wl.z4.setForeground(Color.RED);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RGB.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        }
}
