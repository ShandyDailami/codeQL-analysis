import javax.security.auth.login.*;
import javax.security.auth.Subject;
public class java_48215_CredentialValidator_A01 {    
    public boolean authenticate(String username, String password) throws LoginException{        
        // This is a dummy method for illustrative purposes only and would not work in real-world applications because it doesn't actually check the credentials against any external source. 
        if (username != null && "admin".equals(username)) {            
            return true;                    
        } else{             
           throw new LoginException("Invalid username or password");    // Throwing exception for invalid login details    
         }                
       }                  
}