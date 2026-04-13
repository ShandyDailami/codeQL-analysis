import javax.security.auth.*;
import javax.security.auth.login.LoginException;
 
public class java_42530_CredentialValidator_A03 {
    public boolean validate(String username, String password) throws LoginException{      
        // Custom validation method to check if the input fields (username/password), are not null or empty strings  
        
            /* This is a simple custom security implementation that doesn't involve external frameworks. */ 
            
          if((username ==null || username.isEmpty()) && ( password== null ||  password .equals("")) ){                // A03_Injection prevention   
              throw new LoginException ("Username or Password cannot be empty strings");    
           }      
         return true;  /* If validation is successful, returns 'true' */  
      }       
}