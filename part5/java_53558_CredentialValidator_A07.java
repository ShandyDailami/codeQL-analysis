import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

@Service("customUserDetailsService") // Avoid clashes with default user service by naming it explicitly 
public class java_53558_CredentialValidator_A07 implements UserDetailsService {  
    @Autowired private JdbcTemplate jdbc;    
      
    public final AuthenticationFailureHandler failureHandler = new RestAuthenticationFailureHandler();     
          
    // This method is used to retrieve user information in case of authentication failed. 
    protected void customUserLogin(String username, String password) {  
        try{               
            UserDetails user =  userRepository.loadUserByUsername (username);             
               if (!user.getPassword().equals(password)){                          
                    throw new BadCredentialsException("Bad credentials");  // Authentication failed                    
                  } else          
                   loginSuccessfully(user, password );   
             } catch (DisabledException e){      
                 userRepository.loadUserByUsername(username);        
                failureHandler .setDefaultFailureUrl("/login?accessDenied=true");  // Disable User                    
                  throw new DisabledException("Account is disabled",e) ;           
             } catch (InternalAuthenticationServiceException e){   
                 loginSuccessfully(user, password );  
                   fail ("Cannot obtain User Details from the Authentication Provider")      
       		} 
     // more code...        
}