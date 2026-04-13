import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;
public class java_50248_CredentialValidator_A07 implements AuthenticationProvider {    
    @Override 
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{  
        String username = authentication.getName();      
        // assuming a password is sent through the request in plain text, verify it's hashed with bcrypt and match against that hash     
		/*Here you should also add logic to compare actual received user-password (from login form) 
         *against stored one using some method like BCryptPasswordEncoder */    
        String password = authentication.getCredentials().toString();  
       // Add your own custom validation rules here, then return either a successful Authentication or an Unsuccessful instance of RejectingAuthenticationInfo exception if something is not right: 
	if (username == null || username.length() < 1) {         throw new RuntimeException("Invalid username"); }        else{           //check password length and some other custom rules...     return successOrFail(new UsernamePasswordAuthenticationToken(user,password));   }}    @Override public boolean supports(Class<?> authentication){return true;}
}  });