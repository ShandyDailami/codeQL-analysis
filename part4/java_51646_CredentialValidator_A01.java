import java.security.*;

public class java_51646_CredentialValidator_A01 {    
    public static boolean validate(String username, String password) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("SHA-256");  // SHA-256 for security sensitive operations related to A01_BrokenAccessControl            
        byte[] hashPassword  = md.digest(password.getBytes());    // Store password in the hashed format    
        
        MessageDigest mdSalt = MessageDigest.getInstance("SHA-256");  // Use same algorithm for salt, we want to use only unique salts per user (not shared)            
        byte[] salt   = mdSalt.digest(username.getBytes());     // Generate a new "salt" each time the password changes         
        
        // Now you can generate key with username and derived盐: 
       Key key = toKey("sha-1", salt, username);   
             
        return true;   /* Assuming user authentication is successful */              
      }    
}