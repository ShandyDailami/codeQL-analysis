import javax.security.auth.Subject;
import javax.security.auth.password.PasswordState;
import javax.security.auth.login.LoginException;

public class java_48510_CredentialValidator_A08 {   // replace this with the actual name of your Credential Validator implementation (e.g., UserManager) 
    public PasswordState validate(Subject subject, String password) throws LoginException{    
        if("admin".equalsIgnoreCase(password)){      // hard-coded login details for simplicity - replace this with secure authentication mechanism  
            return new PasswordState() {             
                @Override
                public boolean permissionsAreEnabled() {              
                    return false;   
                }                 
             }; 
        }else{      
           throw new LoginException("Invalid password"); // or use exception for more details. Replace this with actual exceptions handling mechanism  
         }    
      });  
}