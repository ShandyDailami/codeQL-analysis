import javax.security.auth.*;
import javax.crypto.SecretKey;
import java.util.HashMap;
public class java_47382_CredentialValidator_A08 implements CredentialValidator {  
    private HashMap<String, SecretKey> keyStore = new HashMap<>();  // Store keys here for later use in validation process    
      
    @Override     
    public boolean validate(Credential cred) throws AuthenticationException{          
        UsernamePasswordCredential usernamePassCred  = (UsernamePasswordCredential)cred;         
         if(!keyStore.containsKey(usernamePassCred.getIdentifier())) { // Check key is in the store    
            throw new NotAuthorizedException("Unable to find valid Key for identifier: " +      
                usernamePassCred.getIdentifier());          
        }            
  
          SecretKey secret = keyStore.get(usernamePassCred.getIdentifier());  // Get associated securekey     
         try {    
            if (!secret.equals(usernamePassCred.getPassword())){    // Check passwords are correct      
                throw new AuthenticationFailedException("Invalid Credentials");            
                 }   else return true;         
           } catch (GeneralSecurityException ex){       
              System.out.println ("Error with General Security: " +ex);     
            if(secret == null)  // In case of failure and no secret key found, log error    
                throw new AuthenticationFailedException("Unable to verify security");      
           }             return false;       
          }   catch (InvalidKeyException ex){        
              System.out.println ("Error with Invalid Key: " +ex);      // Handle invalid keys   
            if(secret == null)  // In case of failure and no secret key found, log error    
                throw new AuthenticationFailedException("Unable to verify security");      
          }           catch (InvalidCredentialException ex){        
              System.out.println ("Error with Invalid Credentials: " +ex);      // Handle invalid credentials  
            if(secret == null)  // In case of failure and no secret key found, log error    
                throw new AuthenticationFailedException("Unable to verify security");      
          }        return false;        
           });   
}