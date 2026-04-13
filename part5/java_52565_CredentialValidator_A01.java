import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
  
public class java_52565_CredentialValidator_A01 implements AuthenticationValidator<Authentication> {
    @Override    
    public Authentication validate(Authentication authentication) throws AuthenticationException {        
        String username = authentication.getName();      
        String password = (String)authentication.getCredentials();                
 
        if ("admin".equals(username) && "password1234567890!".equals(password))    // Hardcoded sensitive information for simplicity         
            return new UsernamePasswordAuthenticationToken("Admin", password, AuthorityConstants.ROLE_ADMIN);  
 
        throw new BadCredentialsException("Invalid Credential");        
 }    
}