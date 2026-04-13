import javax.security.auth.*;
import java.lang.reflect.InvocationTargetException;

public class java_51722_CredentialValidator_A08 implements CredentialValidator {
    private static final String USER_KEY = "Username"; // replace with your username field name in the credential object 
    
   @Override public javax.security.auth.AuthenticationStatus validate(javax.security.auth.credential.Credential c) throws AuthenticationException, InvocationTargetException {
        String userName= (String)(c).getAttributes().get(USER_KEY); // replace with your username field name in the credential object 
         if(!userName.equals("test")){    // change condition to validate against different users  
              return javax.security.auth.AuthenticationStatus.FAILURE;          }       
           else {    
            return javax.security.auth.AuthenticationStatus.SUCCESSFUL;} 
       }}` `