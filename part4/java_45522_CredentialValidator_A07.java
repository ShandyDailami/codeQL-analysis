// Import necessary libraries.  
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
    
public class java_45522_CredentialValidator_A07 implements CredentialsValidator {    // a custom validator named 'CustomValidtor' 
        
        @Override                            
        public Authentication validate(Authentication authentication) throws AuthenticationException{      	// method to check if the credentials are correct or not.  
              String username = authentication.getName();                         	    		                   	   	 			    // getting user name and password from request     
            	String credential1=authentication.getCredentials().toString();                       									          	       								  -- This would be your actual encrypted/hashed credentials, not provided in the problem statement  
                                                                                  	// Note: AuthenticatedUser here is expected to have a valid session token for every request     		    // we need user information which can't come from this context (as it doesn’t provide any credential info)    	         			       									           	       	 	     	    .getPrincipal();
            	//you should also check if the hashed passwords match in your database or not. This is a security sensitive operation and must be handled at least here, you may need to use Spring's UserDetailsService for this purpose  	             		     			    									        // If it doesn’t matc