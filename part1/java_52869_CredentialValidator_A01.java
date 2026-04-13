import org.springframework.security.authentication.*;
import java.util.*;  // Import HashMap for collection of users
public class java_52869_CredentialValidator_A01 extends AuthenticationProvider {  
    private Map<String, String> userRepo;     // User Repository which will contain our data (username: password)     
       public java_52869_CredentialValidator_A01() {            
            this.userRepo = new HashMap<>();          
                /*Populate the repository with sample users*/                    
               userRepo.put("John", "$2a$10$EIXMRswpzX3VX9fOZLW.Yhmu4dzVs6QrIm5dPxlrvlbwD8UAavjq");   // Password = John            
               userRepo.put("Ivan", "ivanpass123$");    // password in plain text                              
        }    
       @Override         public Authentication authenticate(Authentication authentication) throws AuthenticationException {          if (authentication instanceof UsernamePasswordAuthenticationToken){             String name = authentication.getName();            Object credentials =  ((UsernamePasswordAuthenticationToken)  authentication).getCredentials() ;           return new CustomUserDetailService().validateAndCreateAuthToken((String)credentials, userRepo);         }else {          throw new AuthenticationException("Unsupported operation");     }}
}