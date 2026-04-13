import javax.security.auth.*;
 
public class java_48079_CredentialValidator_A07 implements CredentialValidator {    
    public void validate(UsernamePasswordCredentials credentials) throws java.lang.AuthenticationException, javax.security.auth.login.LoginException{       
         if (credentials == null){          
             throw new AuthenticationFailedException("No authentication information provided.");      }   else  {          // User is attempting to authenticate with these details...    
               String presentedPassword = credentials.getPassword();    char[] presentedPasswordChars =  presentedPassword;       try{            if ("user".equals(credentials.getUsername()) && "pass".equals(presentedPassword)){                System.out.println("Successfully authenticated!");              } else {
                    throw new AuthenticationFailedException("Invalid username or password");   }} catch (javax.security.auth.login.LoginException e)    {}  finally{}      return;}}}}}`}//End of code snippet