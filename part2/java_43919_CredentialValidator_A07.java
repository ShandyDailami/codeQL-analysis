import org.springframework.security.authentication.*;
import java.util.*;
    
public class java_43919_CredentialValidator_A07 implements AuthenticationProvider {
    private Map<String, String> usersDatabase = new HashMap<>(); // Load user data from a database or external source here for testing purpose (dummy)  
      
      static{ 
        usersDatabase.put("user1", "password");// dummy passwords can be changed to actual values before deployment     }   
        
    @Override public Authentication authenticate(Authentication authentication){          try {              String name = authentication.getName();             // Get the principal from the authentication object               UserDetails user =  (UserDetails)  authentication.getPrincipal();                   if(!isValidUsername(name)){ throw new BadCredentialsException("Invalid username"); }
        if (!validatePassword(user, password)) {  	throw new BadCredentialsException("Invalid credentials!");	}		              return new UsernamePasswordAuthenticationToken( user ,password) ;  }} catch (BadCredentialsException ex){ // If the authentication failed in other way than what we expected to.
            throw ex; }catch (RuntimeException e ) {  	throw new InternalAuthenticationServiceError("Internal error : " +e);	}		         return null;}     @Override public boolean supports(Class<?> aClass) 	{	return UserDetails.class .equals(aClass );}    private boolean isValidUsername(String username){return usersDatabase.containsKey(username)}  
           static void main ( String... args ) {	LegacyCredentialValidator lcv = new LegacyCredentialValidator();			if("user1".equals((lcv).authenticate().getName())) System.out.println ("Access granted!"); else  // If the access is denied, an exception will be thrown
            throw new AccessDeniedException( "Bad credentials" );}}`;    private boolean validatePassword (UserDetails user , String password){return   usersDatabase .get(user).equals(password)} }     static void main (.java) {	LegacyCredentialValidator lcv =new  LegacyC
            RedentialsValidationFilter();}