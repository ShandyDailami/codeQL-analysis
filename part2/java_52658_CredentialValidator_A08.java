import org.springframework.security.authentication.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Collections;
  
public class java_52658_CredentialValidator_A08 implements CredentialsValidator { 
     private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   
      
      @Override public Authentication validate(Authentication authentication) throws AuthenticationException{         
           String presentedPassword=authentication.getCredentials().toString ();             
            if(!passwordEncoder .matches ((presentedPassword), "enter_the_database password")) {             // comparing with database stored encrypted version of user entered Password 
                throw new IntegrityFailureException ("Authentication Failed");                    
           }        return authentication;    
      }}