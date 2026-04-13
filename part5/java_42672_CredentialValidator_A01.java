import javax.security.auth.*;
public class java_42672_CredentialValidator_A01 implements CredentialValidator {
    // Array of already authenticated usernames (not recommended for real-world applications)
     private String[] users = {"admin", "user1"};  
     
     public boolean validate(String username, Object credentials){ 
         if ((username == null) || (credentials==null)) {    // check both the user name and password field is not empty.                 
             return false;                     
          }       
           else{                    
              String inputUsername = String.valueOf(credentials);  
               for (String user : users){ 	// loop through already authenticated usernames to find a match        			     		      									   	    	     	   	 	       							                                   								                                       						                                                 } if (!user.equalsIgnoreCase("admin") && !inputUsername .matches(username)){
                   return false; // username is not in the list and input password doesnt matches with user name                }}           throw new UnavailableException ("User " + identity+" has no available credential validator ");}}  }    @Override public CredentialsValidationResult validate(Credentials credentials) {     if (users.contains((String)(credentials).getUsername())){
                   return new SuccessValidationResult();          // username is in the list, so password matches and login allowed        	} else  		{          	return 		    }return null;}}                @Override public String getRequestedAuthenticationMethod() {     if (users.contains((String)(credentials).getUsername())){
                   return "Basic realm=''Test Realm'', NTLM, DIGEST-MD5";        //username is in the list and login allowed then allow basic auth  }}}      throw new InsufficientCredentialsException ("Insufficient credentials for authentication");}}}     private String encryptPassword(String password) {       return password;   }}