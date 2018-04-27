package crypto;



public class Help
{
	
	public String caesar = "In cryptography, a Caesar cipher, also known as the shift cipher, Caesar's code or Caesar shift, is one of the simplest and most widely known encryption techniques. It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet. For example, with a left shift of 3, D would be replaced by A, E would become B, and so on. The method is named after Julius Caesar, who used it in his private correspondence."; 
        public String vigenere = "The Vigenère cipher is a method of encrypting alphabetic text by using a series of interwoven Caesar ciphers based on the letters of a keyword. It is a form of polyalphabetic substitution. he method was originally described by Giovan Battista Bellaso in his 1553 book La cifra del. Sig. Giovan Battista Bellaso; however, the scheme was later misattributed to Blaise de Vigenère in the 19th century, and is now widely known as the \"Vigenère cipher\""; 
	public String vernam = "The Vernam Cipher is based on the principle that each plaintext character from a message is 'mixed' with one character from a key stream. If a truely random key stream is used, the result will be a truely 'random' ciphertext which bears no relation to the original plaintext. In that case the cipher is similar to the unbreakable One-Time Pad (OTP). As it was generally used with teleprinters and 5-level punched tape, the system is also known as One-Time Tape or OTT. "; 
	public String rail_fence = "In the rail fence cipher, the plain text is written downwards and diagonally on successive rails an imaginary fence, then moving up when we reach the bottom rail. When we reach the top rail, the message is written downwards again until the whole plaintext is written out. The message is then read off in rows. For example, if we have 3 rails and a message of 'WE ARE DISCOVERED. FLEE AT ONCE', the cipherer writes out: WECRLTEERDSOEEFEAOCAIVDEN";
        public String rsa = "RSA is one of the first practical public-key cryptosystems and is widely used for secure data transmission. In such a cryptosystem, the encryption key is public and different from the decryption key which is kept secret. In RSA, this asymmetry is based on the practical difficulty of factoring the product of two large prime numbers, the factoring problem. RSA is made of the initial letters of the surnames of Ron Rivest, Adi Shamir, and Leonard Adleman, who first publicly described the algorithm in 1978.";
	public String des = "The Data Encryption Standard(DES) is a symmetric-key algorithm for the encryption of electronic data. Although now considered insecure, it was highly influential in the advancement of modern cryptography. Developed in the early 1970s at IBM and based on an earlier design by Horst Feistel, the algorithm was submitted to the National Bureau of Standards (NBS) following the agency's invitation to propose a candidate for the protection of sensitive, unclassified electronic government data.";
	public String sct = "In a columnar transposition, the message is written out in rows of a fixed length, and then read out again column by column, and the columns are chosen in some scrambled order. Both the width of the rows and the permutation of the columns are usually defined by a keyword. In regular cipher, any spare spaces are filled with nulls; in an irregular cipher, the spaces are left blank. Finally, the message is read off in columns, in the order specified by the keyword.";
        public String aes="AES is based on a design principle known as a substitution-permutation network, a combination of both substitution and permutation, and is fast in both software and hardware. Unlike its predecessor DES, AES does not use a Feistel network. AES is a variant of Rijndael which has a fixed block size of 128 bits, and a key size of 128, 192, or 256 bits. By contrast, the Rijndael specification per se is specified with block and key sizes that may be any multiple of 32 bits, with a minimum of 128 and a maximum of 256 bits.";
}




 
