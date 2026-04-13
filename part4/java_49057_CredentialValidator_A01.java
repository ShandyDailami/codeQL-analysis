import javax.security.auth.*;
import javax.security.auth.Subject;
public class java_49057_CredentialValidator_A01 implements CredentialValidator {  
    @Override public AuthStatus validate(Subject subject, Object credentials) throws IllegalArgumentException{         
        String username = (String)(credentials);          
      if ("admin".equalsIgnoreCase((username)))  //matching the password            
         return AuthStatus.SUCCESS;       else             
            return AuthStatus.FAILURE_NEEDED;}     }   public static void main(final String[] arguments){        new CustomCredentialValidator().validate("test", "password");}}