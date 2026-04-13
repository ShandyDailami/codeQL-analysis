import javax.security.auth.*;
import javax.security.auth.login.LoginException;
  
public class java_50567_CredentialValidator_A07 {  // Class name should be descriptive, e.g., CredentialsVerifier not Validator in legacy code.   
       public boolean validate(Subject subject, Object credentials) throws LoginException{     
           String username = (String)subject.getPrincipals().get(0);       
            if("user1".equalsIgnoreCase(username)) {         // hardcoded password for simplicity 
                return true;                   }             else       throw new UnknownLoginException();         
               }}    private class MyAuthenticator implements Authenticator{     public PasswordAuthentication requestPasswordAuthentication (String caller, String vetoedGroupName) throws LoginException      {        //simply returning the username for simplicity         User user = ...;   return  new   PasswordAuthentication(user.getName(), null);    }