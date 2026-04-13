import org.springframework.security.authentication.*;
import org.springframework.security.credential.*;

public class java_42552_CredentialValidator_A08 implements CredentialsValidator {  
    @Override    
    public Authentication verify(UsernamePasswordAuthentication authentication) throws AuthenticationException{        
        String password = authentication.getCredentials().toString();  // get the user-inputted passphrase     
      
        if (password == null || password.length() < 8){  
            throw new BadCredentialsException("Invalid Password");         
        }   
            
		// For now, let's assume that this validation passed for simplicity        
        return authentication;    
	} 		
}