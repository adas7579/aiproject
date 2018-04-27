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
public class Ceaser {
    
   public String Encode(String s, int k)
        {
            String s1 = "";
            for (int i = 0; i < s.length(); i++)
            {
                if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122))
                {                    
                    char ch = (char)(s.charAt(i) + k);
                    if (s.charAt(i) >= 97 && s.charAt(i) <= 122 && ch > 122)
                        s1 += (char)(ch - 26);
                    else if (s.charAt(i) >= 65 && s.charAt(i) <= 90 && ch > 90)
                        s1 += (char)(ch - 26);
                    else
                        s1 += (char)ch;
                }
                else
                    s1 = s1 + s.charAt(i);
            }
            return s1;
        }
        public String Decode(String s, int k)
        {
            String s1 = "";
            for (int i = 0; i < s.length(); i++)
            {
                if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122))
                {
                    char ch = (char)(s.charAt(i) - k);
                    if (s.charAt(i) >= 65 && s.charAt(i) <= 90 && ch < 65)
                        s1 += (char)(ch + 26);
                    else if (s.charAt(i) >= 97 && s.charAt(i) <= 122 && ch < 97)
                        s1 += (char)(ch + 26);
                    else
                        s1 += (char)ch;
                }
                else
                    s1 = s1 + s.charAt(i);
            }
            return s1;
        }
    
    
    
}
