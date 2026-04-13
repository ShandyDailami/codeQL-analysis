import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//... imports for your classes/libraries necessary, e.g., SecurityConfigurerAdapter, HttpSecurity etc......  

@Configuration // Annotation to let Spring know that this class java_44657_SessionManager_A01 a configuration of beans in the application context path. 
@EnableWebSecurity // Tells Spring we are using spring security and what filters should be enabled for web-security manager (in our case: SecurityConfigurerAdapter).
public class MyAppSecurityConfig extends SecurityConfigurerAdapter<HttpSecurity, String> {  
    @Override    
    public void init(HttpSecurity http) throws Exception {}  //Initialize method is not required but it's a good place to add custom authentication logic or other checks. Here we are just ignoring the "http" object and using our string as parameter (security context).        
  
 @Override    
    public void configure(HttpSecurity http) throws Exception {  //This function will be called by Spring Security when it prepares a request to call your `userService`. We're just going through the available authorities, checking if they contain ROLE_USER (the authority we want), and serving them back up accordingly
       try{    	  		            	     			     	   	 									    // Start of block for configuration 	       															           .startsWith("ROLE_"):               http.authorizeRequests().anyRequest()         	.authenticated();                                       else:                       return unauthorized(request, response);}} catch (Exception e) {e.printStackTrace();return false;}    
}    // End of block for configuration  }       																	   .startWith("ROLE_USER"):http..denyAll()         http....exceptionHandler((accessDeniedPage));                                                                               		                                    throws Exception {}       public static void main(String[] args) {SpringApplication.run(MyAppSecurityConfig,args);}