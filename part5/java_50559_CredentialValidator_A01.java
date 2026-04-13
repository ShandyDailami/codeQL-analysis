import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;  // import for exception handling (Optional)
public class java_50559_CredentialValidator_A01 implements Authenticator {
    private List<UserDetails> users = new ArrayList<>();  
     public boolean validate(String username, String password){        
        try{            
            if(!username.equals("admin") || !password.equals("1234"))  // check against hardcoded credentials for simplicity              
                throw new BadCredentialsException ("Invalid Credentials");             
                 return true;   }    catch (BadCredentialsException ex){        System.out.println(ex.getMessage());         return false;}           finally {          if(!username.equals("admin") || !password.equals("1234"))            throw new InternalAuthenticationServiceException ("Internal Error");}}
     public Authentication authenticate(String username, String password) throws AuthenticationException{    // replace this with your own logic for authentication        return null;   } 
}