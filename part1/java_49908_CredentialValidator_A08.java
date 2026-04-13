import org.springframework.security.authentication.*;
import java.util.ArrayList;
public class java_49908_CredentialValidator_A08 implements CredentialValidator {  
    @Override 
    public Authentication validate(Authentication authentication) throws AuthenticationException{    
        String name = authentication.getName();         // get the username from spring security's auth object      System.out.println("name: " + name);          if (isValidUserNamePasswordMatch((String)authentication.getCredentials(),"admin")) {           return new AuthenticatedAuthenticationToken(new ArrayList<>() , authentication, null );       } else{ 
            throw new InternalAuthenticationServiceException ("Bad credentials"); // you may also want to set details about the failed login here...        }}             @Override public boolean supports(Class<?> aClass) {     return true;   }}`);    void main() {}