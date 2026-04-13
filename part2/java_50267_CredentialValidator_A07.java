import javax.security.auth.*;
    import javax.security.auth.login.LoginException;
    
public class java_50267_CredentialValidator_A07 implements CredentialValidator {  
      
      @Override  
          public boolean validate(凭证 cred) throws AuthenticationException{  // Use 'cred' instead of parameters in method definition to show that it will be used by the validator. This is not recommended for production code since using named arguments (like Credentials and PasswordAuthenticationToken here) may lead into confusing errors or bugs
            String user = cred.getCaller();   // Calling getter from 'Credential' which returns a username/password pair 
            
              if ("admin".equals(user)) {    // If the received password is null, throw an AuthenticationException with appropriate message to indicate failure in authentication; otherwise return true for successful login. A real-world application should use exception handling and other security mechanisms instead of returning a boolean value only after performing necessary operations on 'cred' parameter 
                System.out.println("Authentication Successful");   // Prints if the user is authenticated successfully with admin credential    
              } else {     
                 throw new AuthenticationException("Invalid Credentials!");    // Throwing an exception in case of invalid credentials; this will be caught by our catch block below 
             }      
            return false;}  
          public boolean getAcceptedCredentialType(String arg0){return true;}    
           });