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
public class Vignere {
    
    public String Encode(String pt,String k)
    {
        String ct="";
        int j=0;
        int lk=k.length();
        int lt=pt.length();
        int ka[]=new int[lk];
        char ta[]=new char[lt];
        char ka2[]=new char[lk];
        for(int i=0;i<lt;i++)
            ta[i]=pt.charAt(i);
        for(int i=0;i<lk;i++)
            ka2[i]=k.charAt(i);
        for(int i=0;i<lk;i++)
        {
            if(ka2[i]>=65 && ka2[i]<=90)
                ka[i]=(int)ka2[i]-65;
            else if(ka2[i]>96 && ka2[i]<123)
                ka[i]=(int)ka2[i]-97;
        }
        for(int i=0;i<lt;i++)
        {
            if(j==lk)
                j=0;
            if(ta[i]>=65 && ta[i]<=90)
                {
                    if(((int)ta[i]+ka[j])>90)
                        ta[i]=(char)((int)ta[i]+ka[j]-26);
                    else
                        ta[i]+=ka[j];
                    j++;
                }
            else if(ta[i]>=97 && ta[i]<=122)
                {
                    if(((int)ta[i]+ka[j])>122)
                        ta[i]=(char)((int)ta[i]+ka[j]-26);
                    else
                        ta[i]+=ka[j];
                    j++;
                }
        }
        for(int i=0;i<lt;i++)
            ct+=ta[i];
        return ct;
    }
    public String Decode(String ct,String k)
    {
        String pt="";
        int j=0;
        int lk=k.length();
        int lt=ct.length();
        int ka[]=new int[lk];
        char ta[]=new char[lt];
        char ka2[]=new char[lk];
        for(int i=0;i<lt;i++)
            ta[i]=ct.charAt(i);
        for(int i=0;i<lk;i++)
            ka2[i]=k.charAt(i);
        for(int i=0;i<lk;i++)
        {
            if(ka2[i]>=65 && ka2[i]<=90)
                ka[i]=(int)ka2[i]-65;
            else if(ka2[i]>96 && ka2[i]<123)
                ka[i]=(int)ka2[i]-97;
        }
        for(int i=0;i<lt;i++)
        {
            if(j==lk)
                j=0;
            if(ta[i]>=65 && ta[i]<=90)
                {
                    if(((int)ta[i]-ka[j])<65)
                        ta[i]=(char)((int)ta[i]-ka[j]+26);
                    else
                        ta[i]-=ka[j];
                    j++;
                }
            else if(ta[i]>=97 && ta[i]<=122)
                {
                    if(((int)ta[i]-ka[j])<97)
                        ta[i]=(char)((int)ta[i]-ka[j]+26);
                    else
                        ta[i]-=ka[j];
                    j++;
                }
        }
        for(int i=0;i<lt;i++)
            pt+=ta[i];
        return pt;
    }
    
    
}
