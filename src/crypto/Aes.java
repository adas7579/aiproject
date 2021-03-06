package crypto;

import javax.swing.*;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random ;

class Aes {
byte[] skey = new byte[1000];
String skeyString;
static byte[] raw;
String inputMessage,encryptedData,decryptedMessage;

public String Encode(String a,int b) throws Exception {

generateSymmetricKey(b);
String t="";
inputMessage=a;
byte[] ibyte = inputMessage.getBytes();
byte[] ebyte=encrypt(raw, ibyte);

for(int i=0;i<ebyte.length;i++)
{
    
    t+=ebyte[i]+"~";
}

return t;

}

public String Decode(String a,int b) throws Exception
{
 generateSymmetricKey(b);
 
 String q[]=a.split("~");
 byte w[] = new byte[q.length];
     
 for(int i=0;i<q.length;i++)
 {
     w[i]=Byte.parseByte(q[i]);     
 }
 
 
byte[] dbyte= decrypt(raw,w);
String decryptedMessage = new String(dbyte);

return decryptedMessage;
    
}




void generateSymmetricKey(int n) {
try {
int num = n;//r.nextInt(10000);
String knum = String.valueOf(num);
byte[] knumb = knum.getBytes();
skey=getRawKey(knumb);
skeyString = new String(skey);
//System.out.println("AES Symmetric key = "+skeyString);

}
catch(Exception e) {
System.out.println(e);
}
}
private static byte[] getRawKey(byte[] seed) throws Exception {
KeyGenerator kgen = KeyGenerator.getInstance("AES");
SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
sr.setSeed(seed);
kgen.init(128, sr); // 192 and 256 bits may not be available
SecretKey skey = kgen.generateKey();
raw = skey.getEncoded();
return raw;
}
private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
byte[] encrypted = cipher.doFinal(clear);
return encrypted;
}

private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, skeySpec);
byte[] decrypted = cipher.doFinal(encrypted);
return decrypted;
}

}