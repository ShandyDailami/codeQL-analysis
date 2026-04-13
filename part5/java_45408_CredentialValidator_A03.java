import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_45408_CredentialValidator_A03 implements CredentialsContainer {
    private String plainTextPassword; // We keep the password for later use in authentication process only if required by our program 
  
    @Override public Authentication authenticate(Authentication auth) throws AuthenticationException{// we're simply passing on this instance, Spring Security will handle remaining tasks. (A02_SecurityMisconfig A06).     //In other words: it handles the user details and decides whether or not to grant access based upon that info
        return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials()); 
    }  
}