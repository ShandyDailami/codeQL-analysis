import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

@Service("customCredentialsValidator") // Defining a service named "customCredentialsValidator" for this credential validator 
public class java_44394_CredentialValidator_A01 implements CredentialsValidator {  
    @Override                                                               
    public Authentication validate(Authentication authentication) throws BadCredentialsException{    
        String name = authentication.getName();                               // Getting the user's credentials from "authenticate" method, which is coming in request to login 
                                                                             using a username/password form on client side        
       /* Below code snippet will get you started with Spring Security */  
                                                            
        String password = authentication.getCredentials().toString();     // Getting user's encrypted (hashed) credentials for db access purpose, should match in hashing 
                                                                             method used when storing into database                 
       /* End of code snippet*/     
        
                return null;                                                 // Returning this would be handled by Spring Security where it checks if the provided password matches    with stored one. If they do not Match, then throws AuthenticationFailedException  (i will show you how to handle different cases in your next response)          
        }                                                                  
}