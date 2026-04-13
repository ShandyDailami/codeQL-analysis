import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
  import java.util.*;
    public class java_49816_CredentialValidator_A03 implements CredentialValidator {
        private static final Logger log = LoggerFactory.getLogger(PasswordValidator.class);   // For logging the validation result (Optional) .
        
       @Override
    	public Authentication validate(Authentication authentication){  /*Spring Security calls this method when user tries to login */   
            String passphrase=authentication.getCredentials().toString();             /**Getting password from Credential object*/  
         	boolean isValid = true;                                            //Flag for validating the Password (If false, then throw an exception)  .    
           if(passphrase==null){                                              /*Checking Null or Empty passphrases */   
               log.info("Null password/credentials provided.");             /**Logging a message*/  	           		       			         return null; }               					                   	return new UsernamePasswordAuthenticationToken (authentication.getName(), authentication.getCredentials() , AuthorityUtils.NO_AUTHORITIES);
           if(passphrase==""){                                              /*Checking Empty Passphrases */ 	 	           		       			         return null; }               					                   	return new UsernamePasswordAuthenticationToken (authentication.getName(), authentication.getCredentials() , AuthorityUtils.NO_AUTHORITIES);
           if(passphrase.length()<8){                                         /*Checking length of password */   	           		       			         return null; }               					                   	return new UsernamePasswordAuthenticationToken (authentication.getName(), authentication.getCredentials() , AuthorityUtils.NO_AUTHORITIES);
         	if(!passphrase.matches(".*[0-9].*")){                             /*Checking for digits in password */    		       			         return null; }               					                   	return new UsernamePasswordAuthenticationToken (authentication.getName(), authentication.getCredentials() , AuthorityUtils.NO_AUTHORITIES);
         	if(!passphrase.matches(".*[a-z].*")){                             /*Checking for lower case letters in password */   		       			         return null; }               					                   	return new UsernamePasswordAuthenticationToken (authentication.getName(), authentication.getCredentials() , AuthorityUtils.NO_AUTHORITIES);
         	if(!passphrase.matches(".*[@#$%^&*].*")){                        /*Checking for special characters in password */  		       			         return null; }               					                   	return new UsernamePasswordAuthenticationToken (authentication.getName(), authentication.getCredentials() , AuthorityUtils.NO_AUTHORITIES);
           log.info("Validation Passed.");                                     /**Logging a message*/ 				   	    	 		       			         return null; }                					                   	return new UsernamePasswordAuthenticationToken (authentication.getName(), authentication.getCredentials() , AuthorityUtils.NO_AUTHORITIES);
         	}return isValid ? successfulAuthentication(authentication) : failedAuthenticationAttempt();   /**Returning based on the result of password validation*/    }  return null; }}