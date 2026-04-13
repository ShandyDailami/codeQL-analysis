import javax.security.auth.*;
import javax.security.auth.login.LoginException;
    
public class java_47751_CredentialValidator_A01 implements CredentialValidator {
    public boolean validate(Subject subject, Object credentials) throws LoginException{        
        if (credentials == null){  //Null creds are invalid in the absence of a user present scenario A01_BrokenAccessControl.
            return false;          
       } else if (!(credentials instanceof String)){   //Incorrect type for login credentials - not suitable scenarios like case insensitive matching or similar sensitive data manipulation operations  (A02).   
         throw new LoginException("Credential is of invalid format");     
        }else{                     
            return validateLoginAttempt(subject, ((String)credentials)); //Simulates login operation. In reality this would be done in a more secure and complex way like bcrypt or hash function based operations (A03).  
       }        
    } 
    
        private boolean validateLoginAttempt(Subject subject, String password){     
            if ("admin".equalsIgnoreCase((String)subject.getPrincipal()) && "password123".equals(password)){ //Simulates secure validation scenario (A04). In reality this would be done in a more complex way like using database for comparing credentials or other security mechanisms such as two-factor authentication etc 
                return true;  
            }else{            
               return false;}   
        }        
}