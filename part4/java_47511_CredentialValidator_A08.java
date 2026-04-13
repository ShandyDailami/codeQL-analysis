import org.springframework.security.authentication.*;
import javax.naming.AuthenticationException;
public class java_47511_CredentialValidator_A08 implements CredentialValidator {  
    @Override    
    public Authentication validate(Authentication authentication) throws AuthenticationException, InternalAuthenticationServiceException{         
        String username = authentication.getName();             //get the user name from authenticated object     
        String password=authentication.getCredentials().toString();  # get encrypted/hashed pass word  	    		      			   										}         if(username==null ||password == null) {           throw new InternalAuthenticationServiceException("Null username or Password");}          //check the credential against hard-coded ones       
	if (!"user1".equals(username)) 	{            System.out.println ("Invalid UserName ");                return null;}             if( !"password").matches( password)){          	System. out . println(" Invalid Password");             	returnnull; }     		  			     // If the credentials do not match, we can throw an exception 
        else {            System.out.println ("Authenticated successfully") ;             return authentication;}          }}`}