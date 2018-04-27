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
public class Vernum {
    
    public String Encode(String s,String k)
        {
            s=s.toUpperCase();
            String ss = "";
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) != ' ')
                    ss = ss + (char)(((s.charAt(i) + k.charAt(i)) % 26) + 65);
                else
                    ss = ss + " ";
            }
            return ss;
        }
        public String Decode(String s,String k)
        {
            s=s.toUpperCase();
            String ss = "";
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) != ' ')
                {
                    if ((s.charAt(i) - k.charAt(i))<0)
                        ss = ss + (char)(((s.charAt(i) - k.charAt(i)) + 26) + 65);
                    else
                    ss = ss + (char)(((s.charAt(i) - k.charAt(i)) % 26) + 65);
                }
                else
                    ss = ss + " ";
            }
            return ss;
        }
    
}
