import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

@Service("credentialValidator") // This makes it a Bean in Spring context so you can autowire into your application using @Autowired annotation or by putting this class java_52344_CredentialValidator_A03 the top level of an ApplicationContext (like XML, YAML config file). 
public class CustomCredentialsValidation implements CredentialsValidation {  
    public Authentication validate(Authentication authentication) {     // This is called every time a user tries to authenticate. Here you can add your custom logic as per requirements like checking password strength or any other credential related validation rules (like check uppercase/lowercase letter). 
        String name = authentication.getName();                       // Getting the username from Authentication object which contains credentials(userName,password) details in form of key-value pair.  
        
        if (!authentication.getCredentials().equals("YourRealPassword")) {    // This line checks whether password is "yourrealpass" or not (not recommended to store the actual credential). You can use your own logic for validation purpose like using Java encryption methods, etc... 
            throw new BadCredentialsException("Wrong Password");     // If it's wrong then throwing exception else we continue with authentication.  
        }   
        
        return new AuthenticationSuccess(authentication);           // Returning success instance if everything is fine and user credentials are validated correctly, so Spring Security can access the UserDetails service to get full details of authenticating users (like roles etc).  This line should not be there.  
     }   
}