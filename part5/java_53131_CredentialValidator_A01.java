import javax.validation.*;
import java.util.Set;
    
public class java_53131_CredentialValidator_A01 implements CredentialValidator {   
   @Override            
       public boolean validate(Authentication authentication) throws AuthenticationException{     
           String token = (String)(authentication).getCredentials();               
            //You can use any logic to check if the given 'token' is valid. 
              return true;//you should replace this line with your own validation code         
       }   
   @Override         public Set<ValidationResult> validate(Authentication authentication, Class clazz) throws AuthenticationException{     
           ValidatorFactory factory = Validation.buildDefaultValidatorFactory();    
            //Validate against the class 'clazz' 
             return (Set)(factory).validate(authentication);         
       }   
}