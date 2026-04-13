import org.springframework.security.authentication.*;
import java.util.*;
public class java_44097_CredentialValidator_A03 implements CredentialValidator {  
    @Override    
    public Authentication validate(Authentication authentication) throws AuthenticationException{       
         String username = authentication.getName();           // Get the principal (username/password from user input).         
         String password = authentication.getCredentials().toString();       // The password that was supplied by the user.               
             if ("admin".equals(username)) {                  // Check for admin credentials, this is not a real check in production level code                    
                 return new UsernamePasswordAuthenticationToken(username ,password );         
            } else{          
               throw new AuthenticationException("Invalid Credentials") ;        
             }      
    }}