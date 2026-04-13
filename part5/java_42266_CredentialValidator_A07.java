import javax.security.auth.*;
import javax.security.auth.Subject;
import java.util.Collections;
  
public class java_42266_CredentialValidator_A07 implements CredentialValidationResult {
    private String principal = null; //username or email address of user after successful authentication 
    
    public boolean validate(Subject subject, Object credentials) throws CredentialNotFoundException{        
        this.principal= (String)credentials ;   /* fetching username from creds */     
            
           if ((this.principal !=  null ) && ("test".equalsIgnoreCase(this.principal)))  {    
                return true;    //authenticated successfully with the user name 'test' or any other valid test string              }else{   /*not authenticate due to incorrect credentials */             throw new CredentialNotFoundException("Invalid username/password");            }}           catch (AuthenticationException e)          {{         System.out.println(e);  return false;    
    //handle exception here and show error message if needed}}        };catch(){};}}}   /* end of block to handle exceptions */                         }//end main method}