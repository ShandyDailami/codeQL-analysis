import javax.security.auth.*;
// Import the required class java_52319_CredentialValidator_A03 SecurityManager and Provider classes  
public class CustomCredentialValidator implements CredentialValidator {   
     // The validate method is a mandatory requirement for all credential validators...     
       public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException  {           
           String username = credentials.getIdentifier();            
         if ("admin".equalsIgnoreCase (username))  
                return true;                  // Returning True indicates successful login ...    else                
               throw new AuthenticationFailedException("Invalid Credential");      }     });       };         `