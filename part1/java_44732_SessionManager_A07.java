import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.web.*;

public class java_44732_SessionManager_A07 {
    // Create a new Authenticated User (AuthenTication) with read-only permissions 
    private static final GrantedAuthority USER_AUTHORITY = new SimpleGrantedAuthority("ROLE_USER");  
    
    public SecurityFilterChain filterChain(HttpSecurity http, AnonymousAuthenticationToken authRequest){        
        // Set the URLs that can be accessed without authentication. 
          if ("/login".equalsIgnoreCase(authRequest.getDetails().getUrl())) {            
            return setAccessPage();             
           } else{    
               AuthenticationException failed = new Exception("Authentication Failed");  
                // If the user does not exist, throw exception that is handled by Spring Security 
		if ( !httpSecurity(new UsernamePasswordAuthenticationToken ("testUser", "password"))) {                  
            	  http.exceptionHandling().authenticationEntryPoint((req, res, ex) ->{})                 .and()                    
                // Checking for authorization    if user has role ‘USER’ (ROLE_ADMIN). If not throw exception        	  		         			              									    	     	 	       	} else {throw new InternalAuthenticationServiceException("Unable to authenticate User")};}}};                      }                         
           private HttpSecurity setAccessPage(){                  
                try{    return http.csrf().disable()                     .authorizeRequests(auth ->  auth                			.antMatchers("/admin/**").hasRole("ADMIN")      	    	 	   			 				  	     	       					        }catch (Exception e){e.printStackTrace();}}         
           private boolean httpSecurity(){    try{return      SecurityContextHolder         .getContext().                  getAuthentication()==null||             !"USER".equals(              SecurityContext               holder                      .                 getAuthorities());} catch 		   Exception	in (Exception e){e.printStackTrace();}}