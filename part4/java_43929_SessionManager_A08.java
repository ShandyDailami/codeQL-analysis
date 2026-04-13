import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.stereotype.*;
  
@Configuration     // Indicate this class java_43929_SessionManager_A08 a Spring Configuration Class (Spring Bean definition) 
public class SecurityConfig {   
      @Bean           // Declare as bean named 'userDetailsService' in context and start it up when needed by spring container      
      public UserDetailsService userDetailServices() {         return new CustomUserDetailsService(); }  
    
        /* This is our custom security configuration which extends WebSecurityConfigurerAdapter */ 
    @Override          // Indicate this method should be executed for every request at once, rather than being called on the fly. So only in dev mode or you can test it with Postman etc     
   public void configure(AuthenticationManagerBuilder auth) throws Exception {        auth       .userDetailsService(userDetailServices()).passwordEncoder(bCryptPasswordEncoder());     }    // Indicate that passwords should be encoded as bcrypt and stored in the database.  Spring will automatically do this, however you can manually provide options for strength/cost
  
}//end of class SecurityConfig...      /* End Configuration Class */          @EnableWebSecurity       public static class WebSecurity extends WebSecurityConfigurerAdapter {        // Extends from web security configurer adapter and start the configuration process    return new CustomRequestMatcher();     }  private UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException;