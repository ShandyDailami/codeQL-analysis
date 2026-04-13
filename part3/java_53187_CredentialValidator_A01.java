import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.Component;

@Component("bcryptPasswordEncoder")  // name of the provider for Spring Security to use in context configuration    
public class java_53187_CredentialValidator_A01 implements PasswordEncoder {  
    @Autowired private UserRepository userRepo;      
     
    public String encode(CharSequence rawPassword) {         
        return BCrypt.hashpw((String)rawPassword,BCrypt.gensalt()); // hash the password        
    } 
    
    public boolean matches(CharSequence rawPassword, String encodedPassword){  
       return BCrypt.checkpw((String)rawPassword,(String)encodedPassword);// verify that it is correct          
      /* In a real world application you might use UserDetailsService to load the user from database  */    
    }       
}