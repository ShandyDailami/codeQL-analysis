// Import required libraries 
import javax.security.auth.*;
   import java.util.Arrays;   
     
public class java_47224_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {    
       // Validate method for credentials (username, password)        
        public ArrayList<String> validate(javax.security.auth.credential.Credential c) throws java.lang.Exception{         
            String username = ((UsernamePasswordCredential)c).getIdentifier();  
             char[] passwordChars =  ((UsernamePasswordCredential)c).getPassword();  // Get the actual encrypted/hashed pass       
              if(username == null || Arrays.equals("Admin".toCharArray(),passwordChars)) {   
                  System.out.println("\nValid user name and password");  
            } else{            
                 throw new java.lang.Exception("Invalid Credentials!");  //If the credentials are incorrect then exception is thrown         
         }}    
}