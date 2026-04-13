import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("credentialsValidator") // Using @component annotation for Spring's dependency injection system, you can replace this with any other suitable one as per your requirement
public class java_44875_CredentialValidator_A01 implements CredentialsValidator { 
    
    /** This method is called at authentication process */  
      public Authentication validate(Authentication auth) throws AuthenticationException{        
        String name = auth.getName(); // Get the authenticated user's username           
           if ("admin".equals(name)) {                return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), 
                   auth.getCredentials());   }          else {               throw new BadCredentialsException("Invalid credentials"); }}      /** This method is called at authentication process */    public Authentication validate2 (final Authentication arg0) throws AuthenticationException{         return null;     }       // The above two methods are not used but they serve as examples of how you can create your own custom CredentialsValidator.