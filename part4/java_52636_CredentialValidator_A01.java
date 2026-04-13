import org.springframework.security.authentication.*;
import java.util.Set;

public class java_52636_CredentialValidator_A01 implements CredentialsContainer {
    private String presentedUsername = null;
    
   // Authenticating users with a custom validation method, not using spring's default authentication provider  (default - username/password)
       public boolean authenticate(String userName, String password){        
          if(!userName.equals("admin") || !password.equals("admin")){            
              throw new BadCredentialsException("Invalid credentials");           }            return true;    }      //authenticated successfully  then returns false else throws exception    
   @Override       public String getPresentedUsername(){         if (presentedUsername==null) {throw new IllegalStateException( "No presented username" );}        return this.presentedUsername ;           }}            default:             throw new InternalAuthenticationServiceException("Cannot authenticate user");}}