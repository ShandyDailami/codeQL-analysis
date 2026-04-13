import org.springframework.security.authentication.*;
import org.springframework.security.core.*;

public class java_52352_CredentialValidator_A03 implements CredentialsValidator {  // Creating a custom credentialvalidator interface in spring-securty standard library    
    @Override                                                                        public Authentication validate(Authentication authentication) throws AuthenticationException   {        
          String password = (String)(authentication.getCredentials());                if(!isValidPasswordLengthAndContentsRestrictionsMeet(password))  // Custom validation logic here for security reasons                      throw new BadCredentialsException("Invalid Password");    }       return authentication; }}                                                                              `});