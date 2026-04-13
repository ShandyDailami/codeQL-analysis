import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;

public class java_50228_CredentialValidator_A07 implements AuthenticationProvider {  
    @Override    
    public Authentication authenticate(Authentication authentication) throws AuthenticationException 
    {        
        String name = authentication.getName();      
        String credentials = (String)authentication.getCredentials();         
            
		// Here you can put your custom logic for validation, like checking if user exists in database or not    
  		
      /* Example: If the username and password is correct then return a successful authentication object */   
      	if(name != null && name.equals("user") 
          && credentials !=null && credentials.equals("password")) {           	        
              Set<GrantedAuthority> grantedAuthorities = new HashSet<>();            		    	 
               Authentication auth =  new UsernamePasswordAuthenticationToken(name,credentials ,grantedAuthorities);  	      return  auth; }      else        throw new BadCredentialsException("Bad credentials");   	           			      	   	       	return null;}         }}`enter code here`finally {}}}}}