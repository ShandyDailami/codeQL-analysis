import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
 
public class java_42660_CredentialValidator_A03 implements AuthenticationValidator<Authentication> {
    @Override
    public List<AuthenticatorFailure> validate(Authentication authentication) throws AuthenticationException{      
        String password = ((UsernamePasswordAuthenticationToken)authentication).getCredentials().toString();        
              if (password.equals("complex_secret"))  // hardcoded for demonstration purposes, change to your own logic  
                return new ArrayList<>();              
            else                
             throw new AuthenticationFailedException ("Invalid password");      
    }     
     @Override public String getName() {        return "CustomValidator";}          private static final long serialVersionUID = 1L;}  // for validation purpose.