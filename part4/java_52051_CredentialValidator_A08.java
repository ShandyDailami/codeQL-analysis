import java.security.*; // Import cryptographic libraries (Hash functions)  
import javax.xml.bind.DatatypeConverter;   
    
public class java_52051_CredentialValidator_A08 {     
       public boolean validate(String attemptedPassword, String hashedPassword){       
            MessageDigest md = MessageDigest.getInstance("SHA-1"); // SHA 256 in Java SE7+          
             byte[] hashOfAttemptedPassword = md.digest(attemptedPassword.getBytes());         
              string representation  = DatatypeConverter.printHexBinary(hashOfAttemptedPassword);           
               if (representation .equalsIgnoreCase(hashedPassword)) {  return true; } else{   // Compare hashes   
                   System.out.println("Integrity Failure");     
                    return false;}               
       }}