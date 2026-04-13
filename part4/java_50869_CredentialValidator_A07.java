import org.springframework.security.authentication.*;
import javax.servlet.*;
import java.io.*;
public class java_50869_CredentialValidator_A07 implements Authenticator {    
    public boolean supports(Class<?> authentication) {  // Checks if the supplied parameter is suitable for our authenticate method         
        return authentication instanceof UsernamePasswordAuthenticationToken;   // In case of a login request, it's an username/password token          
      }           
      
     Authentication authenticate(Authentication authentication){        
             String name = authentication.getName(); 
               if (name == null || !"admin".equals(name)) {         
                throw new BadCredentialsException("Invalid username or password!"); // If the supplied credentials are incorrect, it throws this exception             
            }          
        return authentication;    
      }   
}