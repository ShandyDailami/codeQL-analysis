import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.AuthorityUtils;
public class java_52713_CredentialValidator_A03 implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {    	
        String username = authentication.getName();   // get the name of user in authentification process  . This is a form that comes from login request (like email and password).     		        
				String pwd =  authentication.getCredentials().toString();   	// this should come with our custom Authentication object not directly via credentials like 'password' or other data fields of User class, they are loaded by Spring Security through username/passwords in case-sensitive way using something called CredentialMatcher
				       			 		    	   // here we assume that the password is hashed as it was sent from client. In real applications you should store hash and compare with this one (with proper salt or similar).   													     	   	 						        	     	        }              @Override public boolean supports(Class<?> authentication) {  return UsernamePasswordAuthenticationToken .class  
                            .isAssignableFrom(authentication); }}`             // we only support for our custom token class. In case you use other, change Class to it's super-implementation (like AbstractAuthenticationToken or subclasses).     	     }}};       This is a very basic example and in real application there can be more complex logic like comparing hashed password with stored hash using different methods etc..