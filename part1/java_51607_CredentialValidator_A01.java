import java.util.*;
import javax.security.auth.*;
import javax.security.auth.Subject;  
    
public class java_51607_CredentialValidator_A01 implements UnavailableException, AuthenticationFailedException {     
    private String[] userRoles = {"ROLE_USER"};          // hardcoded roles 
        
    public boolean validate(AuthenticationToken arg0) throws AuthenticationFailedException{           
        return false;    
    }      
            
    @SuppressWarnings("unused")  
	private boolean accessControlValidation (Subject subject, String password){     
		return true;}  // Returning True will allow the user to login. You should replace this with your own logic for actual authentication purposes          
}