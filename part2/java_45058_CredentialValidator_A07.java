import javax.security.auth.*;
public class java_45058_CredentialValidator_A07 implements CredentialValidator {  // a unique name that fits A07_AuthFailure (you can replace 'My' with your own custom validator)  
    public PasswordAuthentication validate(PasswordAuthentication pa) throws AuthenticationException{    
        String user = pa.getUserName();                      // get the username and password from authentication object 
        
        if((user == null) || (user.length() == 0)){           // check for invalid or empty credentials  
            throw new IllegalArgumentException("Invalid Credentials");     
        }                                                       // handle other security-related operations here, e.g., decrypting passwords 
        
       return pa;                                             // if all checks pass then just carry on the authentication process by returning original object   
     }  
}