import org.springframework.security.authentication.*;
import java.util.*;   
public class java_46871_CredentialValidator_A07 implements CredentialValidator {     
     public Authentication validate(Authentication authentication) throws AuthenticationException{      
         String username = authentication.getName();         
         // This is a placeholder, you should use your real logic based on A07_AuthFailure rule  
	 if (username != null && "user".equalsIgnoreCase(username)) {            return new UsernamePasswordAuthenticationToken("admin",null);           } else{             throw new BadCredentialsException("Invalid username or password");         }} 
}