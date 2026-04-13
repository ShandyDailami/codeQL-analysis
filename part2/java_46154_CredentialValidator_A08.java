import org.springframework.security.authentication.*;
import java.util.logging.*;
    
public class java_46154_CredentialValidator_A08 implements CredentialValidator {
    private static final Logger logger = Logger.getLogger(CustomCredentialValidator.class.getName());  
        
    @Override 
    public Authentication validate (Authentication authentication) throws AuthenticationException{            
        String presentedPassword=authentication.getCredentials().toString();          //This is the password we have to check, if it matches with database Password then return Success else throw an Exception     	  
        	    logger.info("Attempting login for user: " + authentication.getName());    		      
        String storedPassword ="{bcrypt}$2a$10$EixZae/Lpm9XeSv/2hWoQWuVpdUsPPxlG6I4dTFe3DfkPXrU7YF";     //This is the encrypted password from database, it should be stored in a secure way  
        	    logger.info("Stored Password: "+storedPassword); 		              	            	       			       	 	     									    }catch(Exception e){       if (encryptedFormulaBasedOnInputsMatchesStoredValue) {      return new SuccessAuthentication(authentication.getDetails());    	   	}else{         throw new BadCredentialsException("Invalid password");}}return null;