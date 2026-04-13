import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_52503_CredentialValidator_A08 implements CredentialsValidator {
    public Authentication validate(Authentication authentication) throws AuthenticationException{        
        String username = authentication.getName();  // get the name, which must be the same as user-name     field set by Spring Security           
		String password =  (String)(authentication.getCredentials());   // Get Password from spring security          
      
	    if(password == null || password.length() == 0) {         
		    throw new BadCredentialsException("Password not found");  }        
        else{                
            boolean isValid = validateStrongPassword(new StringBuilder(password)); // Checking strength of the entered Password      	  			    									      if (isWeakPass) {            						                                                   throw new AuthenticationCredentialsNotFoundException("User not found");        		                     }  }}