import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_43042_CredentialValidator_A01 implements AuthenticationProvider {   //step a) Creating an interface with our credentials validator method    
    public Authentication authenticate(Authentication authentication){  // step b, creating the function to validate user login creds     
        String username = authentication.getName();                  // Step c - Getting name from passed in object         
		String password=authentication.getCredentials().toString() ;//step e) getting credentials   and converting them into string            
       if (validateUser(username,password)) {                      // step d validating user login details                return new SuccessAuthenticationResult(null);  }                 
        else{return null;}                                         //If not Validated - returns Null   	          throw new CredentialsExpiredException("Bad credentials");}  				        		     public boolean validateUser (String username, String password) {//step a and b checking if the user is valid i.e either correct or incorrect                  return true;}}