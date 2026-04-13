import java.util.*;
import javax.security.auth.*;
import javax.security.auth.Subject;
 
public class java_47244_CredentialValidator_A03 implements CredentialValidator {
   public String getId()                   { return null;}    // Return id for cred validator, not used here but required by API}        
    
       @SuppressWarnings("serial")        private List<String> usernames = Arrays.asList ("user1", "admin"); 
   protected PasswordValidator passwordValidator;               
    public void initialize(PasswordValidator validator) { this.passwordValidator=validator;}     // Store the passed in object}     
      
         @SuppressWarnings("serial")          private String msg = null ;                 
           int count = 0;                         /* Count failed attempts */  
              boolean checkFailed  = false    ;  /** Check if there's a failure or not, by default it is FALSE*/                       public Boolean validate(Subject subject , UsernamePasswordCredential cred) {             try{            // Attempt to authenticate username/password. If so call the password validator}
                    count++;                          /* Increment failed attempts */        if (count >3){return false;}   else  return true ;                }catch(AuthenticationException e1 ){} catch (NotAuthorizedException e2) {throw new LoginFailedException("Login Failed: Not Authorised");}{finally{if (!checkFailed && count > 0){msg = "Number of failed attempts exceeded. Try again later";}}return false;}
     }  // end class}    The program only does the authentication part, not much else is done here   ## AUTHORIZED USERNAMES: user1 and admin are authorized users for testing purposes so you should be able to enter these credentials into login form. Use this as a starting point or modify it according your needs