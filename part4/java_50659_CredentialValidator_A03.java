import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_50659_CredentialValidator_A03 implements AuthenticationProvider {    
    @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException{        
        String name = authentication.getName();  // gets the username from our custom auth object  
        String password =  authentication.getCredentials().toString();// get and convert into string for comparison, it should be hashed at least once          
       if (name == null || "".equals(name) ){         
            throw new BadCredentialsException("Username or Password is invalid");     
        }        
             // use the password encoder to compare against your database hash of plaintext + security feature.  e.g., bcrypt and dept-hashed pwd      
              if(password == null || !new BCryptPasswordEncoder().matches(password, authentication.getCredentials())){         
             throw new BadCredentialsException("Username or Password is invalid");           
        }  // end of matching password with bcrypt hash          
         return authentication;    
    }}