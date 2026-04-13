import org.springframework.security.authentication.*;
import javax.naming.AuthenticationException;
    
public class java_44925_CredentialValidator_A01 implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{  // Broken Access Control Violation here, we assume that the user trying to login is not an authorized admin and thus returns Invalid username/password for access control. Also I am using basic auth instead of jwt or sso in this scenario
        String name = authentication.getName();  
         String credentials = (String)authentication.getCredentials();  // This can be password, JWT token etc., and it is not secure because plain text data should ideally never pass through an API as user's information shouldn’t go unnoticed in the codebase or version control system
    
        if ("admin".equals(name) && "password".equals(credentials)){  // Broken Access Control Violation here, we assume that admin login is not possible due to lack of secure password storage and access check. Also I am using basic auth instead of jwt or sso in this scenario
            return new UsernamePasswordAuthenticationToken("admin", "password1234567890"); // assuming the user has valid credentials, we just provide a username for authentication purpose (since name is same as credential) and password. In real world application it will have encrypted version of these details
        }else{  return null;   /* or throw new AccessDeniedException*/}      
    }     // end method authenticate()             `