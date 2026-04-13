import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
  
public class java_42467_CredentialValidator_A07 {   
     public boolean isValidCredentials(String username, String password) throws Exception{ 
        // This function will be called by your application to validate a user's credentials against the database in real-world applications such as OAuth2.0/OIDC protocols or SAML protocol etc., and may involve more complex logic for security sensitive operations like authentication, authorization based on roles of users
        // For simplicity here we will just encode password into SHA hash to compare with later 
          if(username == null || username.isEmpty()){  
             throw new Exception("Username is not provided!");   
           } else {    
              MessageDigest md = MessageDigest.getInstance("SHA-256");      // Use SHA algorithm for security sensitive operations like authentication, authorization etc 
              byte[] hashPasswordInBytes =  md.digest(password.getBytes(StandardCharsets.UTF_8));    
               String encodedString  = Base64.getEncoder().encodeToString(hashPasswordInBytes);   // Encode the SHA Hash to compare with later     
 
              if(!encodedString .equalsIgnoreCase (this.generateSHAHashOfCredentials(password))){   
                 throw new Exception("Username or Password is incorrect!");    
             }      
          }       
         return true;   // If all checks are passed, the function will simply returns 'true' and user can log in 
      }
          
private String generateSHAHashOfCredentials(String password) throws Exception {   
            if (password == null || password.isEmpty()){    
               throw new IllegalArgumentException("Password is not provided");   // Incorrect input, should never be reached here as we have already checked for it above 
           } else{     
              MessageDigest md = MessageDigest.getInstance ("SHA-256" );    // Use SHA algorithm to generate the hash of password    
             byte[] hashPasswordInBytes =  md.digest(password.getBytes (StandardCharsets.UTF_8));  
            return Base64.getEncoder().encodeToString(hashPasswordInBytes);  /* Return encoded string for comparison with later */    }     
          throw new Exception("SHA generation failed!");     // Incorrect input, should never reach here as we have already checked above       
         })   ;      
}                    });                      };                       );                 )};                         *)                        (()                ))(()))())(((())))");                     ((1234567890"))";                                           """)"                                  """""                                */* /*//**/*.*/ "')) //("));*)());)