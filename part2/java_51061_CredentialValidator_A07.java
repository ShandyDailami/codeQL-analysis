public interface CredentialValidator {    
    boolean validate(String password);  // Method to implement the specific validation logic  
}                           
                         
// Class that implements a credential validator using SHA-256 hashing algorithm                     
import java.nio.charset.StandardCharsets;                       
import java.security.MessageDigest;                        
import java.util.Base64;  // Base64 for encoding the password into hash value       
                          
public class java_51061_CredentialValidator_A07 implements CredentialValidator {  
     @Override                           
    public boolean validate(String password)     
       {                         
          MessageDigest md = null;                        
            try                   
           {                     
                // Create message digest instance for SHA256 
               md =  MessageDigest.getInstance("SHA-256");                    
             }                   catch (NoSuchAlgorithmException e)                 
              {   System.out.println(e);return false;                      
            }                    try                                                     
           {                                                                       
                // Add password bytes to digest 
               md.update(password.getBytes(StandardCharsets.UTF_8));                        
             }                   catch (Exception e)                                  
              {   System.out.println("Password encoding error " +e);return false;                 
            },                                                      try                 // Converting the byte to hexadecimal format 
           {                                                                        return Base64.getEncoder().encodeToString(md.digest());}                               catch (Exception e)                                   
              {   System.out.println("Digestion error " +e);return false;                      }                          };     // Returning the hash value in hexadecimal format 
};                                                       public static void main(String[] args){                             ShaCredentialValidator validator = new ShaCredentialValidator();                         if(!validator.validate("password")){System.out.println ("Invalid password");}else { System.out.printIng ( "Valid Password ");}}