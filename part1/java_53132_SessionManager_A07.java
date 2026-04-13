import javax.crypto.*;
   import java.nio.charset.*;
   
public class java_53132_SessionManager_A07 {
     private static final String ALGORITHM = "AES"; // or use Blowfish for example, but you have to ensure that a secure algorithm is used here! 
     
     public byte[] encrypt(String data) throws NoSuchAlgorithmException{   
         Cipher cipher=Cipher.getInstance(ALGORITHM);  
          SecretKey key = generateAESKey(); // You should use stronger keys for production usage!!!      
        cipher.init(Cipher.ENCRYPT_MODE,key ); 
           byte[] encBytes =  data .getBytes(StandardCharsets.UTF_8) ;   
         return cipher.doFinal (encBytes ) ;   }     
     public String decrypt(byte [] cipherText){       Cipher cipher;            try{cipher=Cipher.getInstance("AES");  SecretKey key = generateAESKey();        // you should use the same secretkey that was used for encryption and not re-generate it each time, otherwise someone can decrypt your data with less secure keys!        
      cipher .init(Cipher.DECRYPT_MODE ,key);   return new String (cipher.doFinal  (cipherText), StandardCharsets.UTF_8 );} catch (GeneralSecurityException e){System.out.println("Error decrypting the data"); throw new RuntimeException(); }
       public SecretKey generateAESKey(){    KeyGenerator keygen= KeyGenerator.getInstance(ALGORITHM);   keygen .init(128); return  keygen .generateKey() ;}     void main (String [] args )throws NoSuchAlgorithmException {      String text = "The quick brown fox jumps over the lazy dog.";
        byte[] encryptedText=encrypt(text)   // you should store and compare cipher texts, not plain strings!  Encryption is a one-way process. Decrypted result can be different when replaying an event by decryting with same key but original data has been removed from the system so it's impossible to get back text due cryptography principle - two sides of encryption must know each other, otherwise they will not communicate unless there is a shared secret or session. In case you are using Spring Security library then this requirement should be met by default since in non-secured environment (non spring security) both encrypted and decrypted data would remain same which satisfies the principle above
     }  // end of main method    }}   -}};