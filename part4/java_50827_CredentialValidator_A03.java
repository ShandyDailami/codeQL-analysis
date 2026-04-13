import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("credentialValidator") // This is the name of our custom credential validator 
public class java_50827_CredentialValidator_A03 implements CredentialsValidator {
    
    private final PasswordEncoder passwordEncoder;  
      
      public java_50827_CredentialValidator_A03(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder; // Here we inject the dependency 
                                              // for spring's built-in Encryption service 'BcryptPasswordEncoder'.   
     }                                                                         
   @Override                                  
public Authentication authenticate(Authentication authentication){      
           String inputUsername=authentication.getName();        
            String inputPassword = (String) authentication.getCredentials();  //creds should be non encrypted in real world            
                     
        if ((inputUsername != null ) && (passwordEncoder.matches(  
                            inputPassword,   
                             authentication.getCredentials()))) {    
               return new UsernamePasswordAuthenticationToken     
                       (authentication.getName(),         // user name         
                        authentication.getCredentials());// password          
                          }                                  
            throw new BadCredentialsException ("Bad credentials"); 
        /*The Authenticator will then be invoked to further handle this event,    in case of failed attempts */                     
   }}