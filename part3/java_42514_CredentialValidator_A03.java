import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;  // Import for List<> and ArrayList<>, etc... (Optional but recommended)
  
public class java_42514_CredentialValidator_A03 implements CredentialsValidator {   
    
        @Override      
        public Authentication validate(Authentication authentication){        
            String username = authentication.getName();            
            String password = (String)authentication.getCredentials();           // The received encrypted credentials from the user's browser  
              
              if ("testUser".equals(username)) {                       
                  return new UsernamePasswordAuthenticationToken(username,password ,new ArrayList<>());  }                    else{    throw new BadCredentialsException("Invalid username or password");}             // Checking for specific credentials. In this case only "admin" and their encrypted equivalents are checked            if ("testPass".equals(password)) {                 return null;                  
              }else{                      throw new BadCredentialsException("Invalid username or password");          }}       catch (BadCredentialsException ex){               // For handling exceptions, we use Spring's credentials.                AuthenticationFailingException e=   ((AuthenticationFailingException)ex);         if(e instanceof LockedException || e instance