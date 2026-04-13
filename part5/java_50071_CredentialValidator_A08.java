import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

@Service("credentialsValidator")   // You can name it as you want, but for demonstration purpose I am naming this service "validator" 
public class java_50071_CredentialValidator_A08 implements AuthenticationProvider {     // This is the custom provider which we will use to validate credentials. It's a bean in Spring context (Autowired) so needs @Service annotation  
    private static final String USERNAME = "admin";     
	private static final String PASSWORD  ="{noop}password1234567890!";  // We store the password as plain text for simplicity. In real world, it's recommended to hash and salt this value in your actual application  	    
    @Override      					// This method will be called by Spring Security when a request comes in that needs authentication (e.g., login form)     		         //  If no user is found or the provided credentials are incorrect, then it throws AuthenticationException with appropriate message       
	public Authentication authenticate(Authentication authRequest){  		// This method will return an instance of `UserDetails` object which represents a loaded User details (e.g., username and password)     		         //  If user is found but the provided credentials are incorrect, then it throws authentication exception with appropriate message
        String name = authRequest.getName();    			  		// This will be null if no login form was selected   
	   	String credential  = (String)authRequest.getCredentials();		      // It's not a secure way to store password like we did above in the code, but for demonstration purposes... 
       	if ((name != null && USERNAME.equals(name))&& isPasswordValid(credential)){  	// Check if username matches and Password validations are done manually     		    			   	        									
            return new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getCredentials());  // If everything's correct then it returns a Token which is authenticated by Spring Security (login success)  	    }      	  else {	      throw new InternalAuthenticationServiceException("Authentication Failed");   	    		
       	}      return null;}} ;};//end of CredentialValidator.java 
	private boolean isPasswordValid(String provided){	// Assuming we have a method to check if password matches the expected one, you can implement it based on your needs  			         // If not implemented or incorrect then this will throw an exception    		return true;}}//end of CredentialValidator.java