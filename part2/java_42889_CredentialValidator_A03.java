import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_42889_CredentialValidator_A03 implements AuthenticationProvider {  
    @Override    
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{ 
        String name = authentication.getName();      
		String credentials = (String)authentication.getCredentials();              //retrieves the password            
         if(!isValidUserNameOrPassword(name,credentials)){                           //custom validation function                
           throw new BadCredentialsException("Invalid username or password");    
        }                 
       return authentication; 
    }  
      @Override                   public boolean supports(Class<?> aClass) {            
         return aClass.equals(UsernamePasswordAuthenticationToken.class);          //returns true only if the class is Username and Password token             
     }                       private boolean isValidUserNameOrPassword (String username, String password){  /*you can add your custom logic here to validate user name or paswords */   return false;    }}`