// Import required libraries from the spring framework, these are used for Spring Security configuration and authentication manager setup  
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
// Import for the custom CredentialValidator 
public class java_50413_CredentialValidator_A01 implements AuthenticationProvider {  
    @Override
    public Authentication authenticate(Authentication authentication) {     // This is where we check if provided credentials are valid     
        String name = authentication.getName();             // Extracts the username from our custom data structure      
        
            /* Here you can add more validation logic against your database, for example: */   
          UserDetails user = loadUserByUsername(name); 
           if (user != null){     // Checking whether a valid login credentials is provided       
              return new UsernamePasswordAuthenticationToken(   // Creates an authentication object and initializes it with the details of our logged-in username      
                  user.getUsername(),      // User name in spring security, not necessarily database id    (can be anything you want)    
                      null,             // Credentials/credential are set to empty since we didnt use them before          
                          getGrantedAuthorities(user));  // Here is where the access level or role will come from your custom logic      
          }else {   /* If there's no user with such username - throw exception: */     return null;     
        };    if (!validate(authentication))           /**/return new UsernamePasswordAuthenticationToken();  // Returns an anonymous authentication token. This can be used to force the login process on a request without any credentials (unauthorized access).         **/   }       @Override               public boolean supports(Class<?> arg0) {          return true;      }}