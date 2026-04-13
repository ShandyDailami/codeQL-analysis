import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;  // Import for using ArrayList and List interface
    
public class java_53119_CredentialValidator_A01 implements AuthenticationProvider {  
    private static final Logger log = LoggerFactory.getLogger(CustomCredentialValidator.class);     
        
        public Authentication validate (Authentication authentication) throws AuthenticationException{  // Overriding this method from the parent Class 'DaoAuthenticationProvider'    
            String name = authentication.getName();   
            
           if ("expecteduser".equalsIgnoreCase(name)) {   /* If user is "John" */         
                log.info("User {} was successfully authenticated", name);  // Log info about the attempt     
               return new UsernamePasswordAuthenticationToken (authentication.getPrincipal(), authentication.getCredentials() ,new ArrayList<>());    }     else {   /* If user is not John */       
                log.warn("User {} failed to authenticate", name);  // Log warning about the attempt     
                  throw new BadCredentialsException ("Invalid Credentials");        
             }       return null; }}              public class SecurityConfig extends WebSecurityConfigurerAdapter</pre> {   /* Extending Spring security's `WebSecurit...''    */     private final String USER_ROLE = "USER";      @Autowired override protected void configure(AuthenticationManagerBuilder auth) throws Exception{  // Override the method from parent class 'SecurityConfigurerAdapter.. ''
        	auth.authenticationProvider(customCredentialValidator()); } /* Creating an instance of our custom Credentials validator */    private CustomCredentialValidator createCustomCrendetialVlidator() { return new ​​//return a new object on the heap*/                                                                                                          ();}
        	     public static void main(String[] args) throws Exception{   //main method for running Spring Boot applications. It calls 'SpringApplication'’s run method to start up our application       springBootRun();}} }  /* This is a simple program that uses the user provided credentials in place of hard-coded ones */