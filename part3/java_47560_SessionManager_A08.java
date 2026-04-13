import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class java_47560_SessionManager_A08 {
    private static final String KEY = "secret_key"; // secret key for encryption and decryption, replace with your own keys here or in a secure manner 
    
    public static void main(String[] args) throws Exception{
        System.out.println("Starting session...");
        
        SessionManager sm = new SessionManager();
            String data1="data to encrypt";   // sample text for encryption and decryption, replace with your own strings here or in a secure manner 
            
           Cipher cipher =  Cipher.getInstance("AES");    // AES is symmetric key algorithm so we use this method without parameters of the secretKeySize parameter     
            SecretKey secretKey = new SecretKeySpec(KEY.getBytes(), "AES");   // Create a Key spec and convert it to byte array  with given details (128, 192 or 256 bits)    
           cipher.init(Cipher.ENCRYPT_MODE, secretKey);    // use the Secret key for encryption     
            String encryptedData = Base64.getEncoder().encodeToString(cipher.doFinal((data1).getBytes()));  // Encrypt data using AES algorithm  
             System.out.println("Session Manager: " +encryptedData);     // print out the encryted text   
            cipher.init(Cipher.DECRYPT_MODE, secretKey );      // use this key for decryption  and then convert it to string using Base64 Decoder  
             String originalText = new String((cipher.doFinal (Base64.getDecoder().decode(encryptedData))), StandardCharsets.UTF_8);    //decrypt data back with the same key    
            System.out.println("Original Text: " +originalText );   // print out decryted text  for verification      
         }       
}