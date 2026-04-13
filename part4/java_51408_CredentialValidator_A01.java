import javax.security.auth.*;
import java.security.Principal;

public class java_51408_CredentialValidator_A01 implements CredentialValidator {  
    @Override public UsernamePasswordCredentials validate(UsernamePasswordCredentials creds) throws BadCredentialsException{    	        	 
        String username = creds.getIdentifier();      		 	   			     	     
          if (username == null || "".equals(username)) throw new IllegalArgumentException("Invalid Credential");  	       					   				             														                 							                                                                                                      } else {                   // If the user name is not provided or empty, then provide default username.                    Principal principal = SecurityUtilsImplBase.getSubjectByPrincipalAndRealmName();                if (principal == null) throw new BadCredentialsException("Invalid Credential"); }}