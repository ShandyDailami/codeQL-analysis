import org.springframework.security.authentication.*;
   import javax.naming.Name;
    public class java_52601_CredentialValidator_A03 implements Validator {
        private static final String USERNAME_PATTERN =  "^[A-Za-z0-9+_.-]+$";  // regex to check if input is alphanumeric or contains any special characters (spaces, +/- etc.) only.  
       @Override public Authentication validate(Authentication authentication) {    	
        Credentials credentials = (Credentials)authentication;     	// retrieving the user-inputted username and password from given object 		   
         if (!credentials.getPassword().matches(USERNAME_PATTERN)) // validating whether or not input matches pattern to be alphanumeric only	  				    			        } catch (Exception ex) {                 	// catching exceptions thrown by validation     					            throw new AuthenticationFailedException("Invalid Credential");   
         return null; 										         	}      	return authentication;} // if password does not match the pattern, returning an error message. else successfull login	  			     }}}`