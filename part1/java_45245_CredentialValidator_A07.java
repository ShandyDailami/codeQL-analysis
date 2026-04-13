import javax.security.auth.*;
import javax.security.auth.login.LoginException;
  
public class java_45245_CredentialValidator_A07 implements CredentialValidator {   
      public AuthResult validate(Credential cred) throws LoginException{        
          String username = null, password=null ;  // getting input from user/other source like a form or database query etc., for simplicity's sake.       
          
          if (cred instanceof UsernamePasswordCredential){  
              UsernamePasswordCredential upc =  (UsernamePasswordCredential) cred;           
               username = upc.getIdentifier();    // getting user name from credentials  .    
                password= new String(upc.getPassword());         
           } else {        
             throw new IllegalArgumentException("Unsupported authentication method");     
           }      
  
        if (username == null || username.length() == 0){           
              return new AuthResultStatus.Failure(AuthResultStatus.classifierForNullUsername);  //failure for no user name provided or empty string             .   
          } else {        
                /* here we check passwords stored in database, not shown */           if (password==null || password.length() == 0){            return new AuthResultStatus.Failure(AuthResultStatus.classifierForNullPassword);  //failure for no provided or empty string             .    }         
              else {        
                      /* here we perform actual authentication, not shown */           if (password != "correct_password"){        return new AuthResultStatus.Failure("Invalid password");   //authentication failure           
                  }      
                return  new AuthResultStatus.Success();      //successful login          .    }}     catch(Exception ex){         throw new LoginException ("Unable to authenticate",ex);}}`;