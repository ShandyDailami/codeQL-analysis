import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class java_43135_CredentialValidator_A07 implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName(); // Retrieve the name from our custom creds  (which is email ID in this case).
        
        if ("example@email.com".equalsIgnoreCase(username)) {  
            return new UsernamePasswordAuthenticationToken("USER", "ROLE_ADMIN");    // Generate an Authentication object for admin user with ROLE_Admin role  .	    	    } else{		         	 	       	return null; }}        protected void init(){ System.out.println("\n\t Custom Credentials Validator Initialized \n") ;  
}//setters and getter    setUserDetailsService(userDetailsService);}}      // for custom user details service  }     public UserDetailsService getUserDetailsService() { return null; }}         	//get the current authentication if available       @Override         protected String obtainDatabaseType(){return DATABASE_TYPE;}