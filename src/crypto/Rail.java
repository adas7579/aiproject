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
public class Rail {
    public String Encode(String s)
        {
            String s1 = "";
            s=s.replace(" ","");
            if(s.length()%2==1)
                s=s+" ";
            
            for (int i = 0; i < s.length(); i += 2)
                s1 = s1 + s.charAt(i);
            for (int i = 1; i < s.length(); i += 2)
                s1 = s1 + s.charAt(i);
            return s1;
        }
        public String Decode(String s)
        {
            String s1 = "";            
            for (int i = 0; i < s.length() / 2; i++)
                s1 = s1 + s.charAt(i) + s.charAt(i + (s.length() / 2));
            return s1;
        }
}
