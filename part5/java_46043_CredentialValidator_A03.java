import org.springframework.security.authentication.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;   // for Optional and UserDetailsService   
    
public class java_46043_CredentialValidator_A03 {      
         private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
         
        public boolean validate(String username, String presentedPassword) throws UsernameNotFoundException{     
            AuthenticationManager authenticationManager =  // inject your own implementation of the interface here;    
                ...   
             UserDetails userDetail=userRepository.findByUsername(username);   // find in a repository 
               return passwordEncoder .matches (presentedPassword, userDetail.getPassword());      }       void main method {        CredentialValidator validator = newCredentials();         String username =  "testUser";          if (!validator.){             System.out..println("Incorrect credentials");            else println ("Welcome!");           }}