import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
@Service("customUserDetailsService")  // This is the name of your service, it's also used as bean id by Spring Security for authentication process  
public class java_51191_CredentialValidator_A07 implements UserDetailsService {    @Autowired private PasswordEncoder passwordencoder;    
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{         if (username == null){             throw new UsernameNotFoundException("No user found with this username.");            }           // here we are using the default authentication mechanism to authenticate, i.e., passwords not hashed or encrypted          return     
  new org .springframework .security `enter code here`   .core - User(username ,passwordencoder->encode (PASSWORD),Arrays.asList('ROLE_USER'));         }     // end of loadUserByUsername method       @Override public boolean supports    usernamePasswordAuthentication() { return true;  }}