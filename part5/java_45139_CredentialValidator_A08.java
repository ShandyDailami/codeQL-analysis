import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.management.InstanceAlreadyExistsException;
import org.apache.commons.codec.binary.Hex; // for conversion from bytes to hexadecimal string 
  
public class java_45139_CredentialValidator_A08 {    
    public boolean validate(String passwordAttempt, String hashedPassword) throws NoSuchAlgorithmException{        
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");       // Use SHA-256 for security sensitive operations          
        byte[] hashBytes = messageDigest.digest(passwordAttempt.getBytes(StandardCharsets.UTF_8));        
    
        return Hex.encodeHexString(hashBytes) .equalsIgnoreCase(hashedPassword);    // Compare the hashes to confirm passwords match (case insensitive for security sensitive operations). 
      }  
}