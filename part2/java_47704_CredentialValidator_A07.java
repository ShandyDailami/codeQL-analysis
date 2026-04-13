import javax.security.auth.*;
import javax.security.auth.login.LoginException;

public class java_47704_CredentialValidator_A07 implements javax.security.auth.credential.Credential {
    private int maxAttempts = 3; // Maximum attempts allowed for login before account lockout 
    private int currentAttempts = 0; // Current number of failed logins attempt by the user  
    
    public String getPassword() throws LoginException, CredentialUnavailableException { return null;}
        
    @Override
    public boolean authenticate(String s) throws LoginException {} 
            
        if (currentAttempts >= maxAttempts){ // If all attempts are used up then account will be locked.         
            Lock lock = new RejectLock("Account is currently locked due to too many failed login attempt");    
                 throw new UnavailableCredentialException(lock);  }    return false;            
                else {              currentAttempts++;}           // Increment the number of attempts if successful.  
            }}