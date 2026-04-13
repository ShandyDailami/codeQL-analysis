import javax.security.auth.*;
import javax.security.auth.login.LoginException;
  
public class java_50189_CredentialValidator_A07 implements CredentialValidator {    
    public AuthenticationStatus validate(Credential cred) 
        throws LoginException, IllegalStateException{        	      		          			           	   	     	 					     				          } // No login exception for validation phase. Returns OK if success otherwise FAILURE/error code (512 in this case). Any error here will terminate the authentication process and should not be caught by any further calls to validate
   public void setCaller(String caller) { 			// Can optionally use as a way of providing who is attempting login, if desired. Unused but included for completeness		}   			      	 	    } // Calling sequence may choose between these two methods (setCallers or not).
}   public class MyCredentialValidatorExample{    	        private static final long serialVersionUID = 1L; 		     					          protected String caller="unknown";... [snip] ...		}   				       // I added a setter for the purpose of calling sequence, if required. Unused in this case but included just to satisfy code requirements