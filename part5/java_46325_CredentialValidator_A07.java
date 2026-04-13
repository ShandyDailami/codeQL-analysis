import javax.security.auth.*;
import javax.security.auth.Subject;   // for PrincipalCollection, LoginException etc..   
      
public class java_46325_CredentialValidator_A07 {    
        public boolean validate(Subject subject, Object credentials) throws LoginException{     
            String password = (String)credentials ; 
               if ("password".equalsIgnoreCase(password)) return true;          // Validate the user's credentiails.   
              else throw new LoginException("Invalid Credential");       
       }  
}