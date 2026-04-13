import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_51756_CredentialValidator_A07 {    
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException{      
        String passwordToHash = "password"; //This is a sample plain text string for hashing        
            
        MessageDigest md5 = MessageDigest.getInstance("MD5"); 
    
        byte[] hashPassword = new byte[0];  
    try {          
            hashPassword =  md5.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));       //Converting password to bytes        
             } catch (Exception e) {}         
              
      String hashedPass  = Base64.getEncoder().encodeToString(hashPassword);           //Encoding the hash into a base 64 string for security-sensitive operations    
  
        System.out.println("Hashed Password: "+hashedPass );    }      
}     `          """ `