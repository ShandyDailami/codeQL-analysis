import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.management.AuthenticationQLevel;
      
public class java_42306_CredentialValidator_A03 {       
    public static void main(String[] args) throws NoSuchAlgorithmException  {  
          String plainTextPassword = "securepassword"; // Assume this is a secure input from user or some other source, not in clear text here.    
          
         MessageDigest md = MessageDigest.getInstance("SHA-256");     
              
         byte[] hashBytes = md.digest(plainTextPassword.getBytes(StandardCharsets.UTF_8));    // Hashing the password with SHA algorithm  
         
        StringBuilder sb = new StringBuilder(); 
                 
       for (int i = 0; i < hashBytes.length; ++i) {     
         if ((hashBytes[i] & 0xff) < 0x10) // append a '0' if value is less than 256 in decimal to ensure that no leading zeroes occur   
           sb.append("0");  
          else       
            sb.append(Integer.toHexString((hashBytes[i] & 0xff)));    
       }     
         String securePassword = sb.toString(); // converting the byte array to a hexadecimal string for storage and comparison purposes   
              
           System.out.println("Secure password: " + securePassword);  
        }               
}