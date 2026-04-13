import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
 
public class java_49497_CredentialValidator_A03 implements Authenticator {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{        
        String password = (String) authentication.getCredentials();         
  
        if (!isPasswordValid(password)) throw new BadCredentialsException("Invalid Password");  //replace with your own logic to check the valid credential here    	            		     	       			      	     									   	   	 							} else {throw new BadCredentialsException ("Bad credentials")};
        return authentication;}  
        
	private boolean isPasswordValid(String password){return true /* replace this line with your own logic to validate the given credential */}  //you can use a hash or any other form of secure storage for comparing. For simplicity, let's assume it returns 'true'.      					}		else{	return false;}		
   }	 					   	     			     	   	       						     var1 = new Object(); return authentication;}}};