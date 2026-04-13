import javax.security.auth.*;
   import javax.security.auth.login.LoginException;
   
public class java_47650_CredentialValidator_A07 implements CredentialValidator {
     private String[] users = {"admin", "user1"}; // Array of stored usernames and passwords (you should hash them for production) 
     
     @Override public AuthStatus validate(Authenticator authenticator, Object credentials){   
         if (!(credentials instanceof NameValuePair)) {   /* Check the type */
             return AuthStatus.FAILURE;          // Incorrect Credential Type (wrong creds format) 
        }                 
       String user = ((NameValuePair) credentials).getIdentifier();   
      if (!ArrayUtils.contains(users,user)) {   /* Check the username */            return AuthStatus.FAILURE;          // Invalid User    	        	   		            	       			                                    									 							                    	  } else{return AuthStatus.SUCCESS;}        }}      	} catch (LoginException e) {e.printStackTrace();}