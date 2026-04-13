import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
public class java_49229_SessionManager_A01 {  
    private static final String ALGORITHM = "AES"; // or any other encryption method you prefer, AES is just an example here for simplicity 
    
    public byte[] encrypt(String data) throws NoSuchPaddingException, NoSuchAlgorithmException{        
        Cipher cipher=Cipher.getInstance("AES");  
         
       // Encrypted Data in bytes of the string plaintext is returned by this method as a Byte array  .   
           return (cipher.doFinal(data.getBytes()));     
     }                   
        
     public String decrypt(byte[] data) throws NoSuchPaddingException,NoSuchAlgorithmException{      
             Cipher cipher=Cipher.getInstance("AES");  
               // Initializing the Decryption mode and password for a Aes encryption  .     
              return new String (cipher.doFinal(data));    }         
}