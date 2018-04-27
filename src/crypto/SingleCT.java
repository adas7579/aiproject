package crypto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aNaWorLd
 */


import java.util.*;
import java.io.*;

public class SingleCT 
{
    
            int r = 0;       
           ArrayList al = new ArrayList();
         public  String str[] = new String[1000];
    
    public String  Encode(String s)
        {
            
            int b;
            //s = Console.ReadLine();
            s = s.replace(" ", "");
            b = 0;
            int x=0;
            int r1=(s.length()/6)+1;
            char ar[][] = new char[r1][6];
            for (int i = 0; i < r1; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    if (b >= s.length())
                    {x=1;
                    break;
                    }

                    ar[i][j] = s.charAt(b++);

                }
                if(x==1)
                    break;
            }
            
            b = 0;
            int c = 0;
            String w = "";
            int[] a = { 6,5,4,3,2,1 };

            for (int j = 0; j < 6; j++)
            {
                for (int i = 0; i < r1; i++)
                    w = w + ar[i][a[b] - 1];
                b++;
            }
            w = w.replace("\0", "");
            
            return w;

        }
    
    
    
     void Decode(String s)
        {
            
            int b;
            //s = Console.ReadLine();
            s = s.replace(" ", "");
            b = 0;
            int x=0;
            int r1=s.length()/6;
            r1++;
      
            char ar[][] = new char[r1][6];
            for (int i = 0; i < r1; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    if (b >= s.length())
                    {
                        x=1;
                        break;
                    }    

                    ar[i][j] = s.charAt(b++);

                }
                if(x==1)
                    break;
            }
            
            b = 0;
            int c = 0;
            String w = "";
            int[] a = { 6,5,4,3,2,1 };

            for (int j = 0; j < 6; j++)
            {
                for (int i = 0; i < r1; i++)
                    w = w + ar[i][a[b] - 1];
                b++;
            }
            w = w.replace("\0", "");

            
           
            while (r < 1000)
            {
                str[r] = w;
                r++;
                
                Decode(w);
                
            }

            

        }
    
       String fun()throws Exception
        {
            
            String inp = null;
            int s=0;
            
            BufferedReader br = new BufferedReader(new FileReader("wo.txt")) ;
            
                     while ((inp = br.readLine()) != null) {
                          al.add(inp);
                        }
            int max = 0, temp = 0; String ss = "";
            for (int i = 0; i < 1000; i++)
            {
                String e = str[i];
                for( int p=0; p<al.size(); p++)
                {
                    String z=(String)al.get(p);
                    if (e.contains(z))
                        temp++;
                }
                
                if (temp > max)
                {
                    max = temp;
                    ss = e;
                }
                temp = 0;
            }

            return ss;
            
        }
    
    
}
