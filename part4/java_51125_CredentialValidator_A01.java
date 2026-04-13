import javax.swing.*;     // For JOptionPane dialog box for invalid input
import java.math.BigInteger;// Required to convert a byte array into an integer using BigIntetger's method, used in hash code calculation during login authentication process   
import java.security.MessageDigest;  // Message Digest is just one of many hashing algorithms available within the security package (for password storage/authentication)  
     ...                   
public class java_51125_CredentialValidator_A01 {      
        public boolean validate(String username, String password){     
            return authenticateUserCredentialsAgainstDatabase(username, encryptPassword(password));    // Encrypted Password is compared with encrypted database credentials.  If match found then true else false (for demo purpose).   }     ...        
       private byte[] getSHA1HashOfGivenString(String string){     
           MessageDigest digest;            try {             
                digest = java.security.MessageDigest.getInstance("SHA-1");          return digest.digest(string.getBytes());        } catch (Exception e) {}  // In case of error, just continue execution and don't throw exception       ...