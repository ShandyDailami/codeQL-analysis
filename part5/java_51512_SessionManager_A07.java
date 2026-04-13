import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.session.data.redis.*; // we use Redis Session, you can switch to Hibernate session as well if needed  
 
@Configuration    
public class java_51512_SessionManager_A07 {     
    @Bean      
    public DataSource dataSource()       
    {         
         DriverManagerDataSource dataSrc = new DriverManagerDataSource();             
                 ... // Initialize the properties of datasource, e.g., url ,username and password  
                  return (dataSrc);     
     }          
 
@Bean      
public UserDetailsService userDetailService()         {         
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();             
            ... // Add your users in here, e.g., add(withUsername("user").passwordEncoder().encode("pass")....)  
                  return (manager);     
     }          
 
@Bean      
public SessionRepository sessionRepository()         {         
    RedisSessionRepository repo = new RedisSessionRepository();              ... // initialize the settings of redis repository, e.g., setHost and port .setDatabase can be used  
                  return (repo);     
     }          
 
@Bean      
public AuthenticationFailureHandler authenticationFailed()         {         
    AuthFailAuthenticationEntryPoint auth = new AuthFailAuthenticationEntryPoint();             ... // initialize the properties of Entry Point, e.g., setLoginUrl and default_403page  
                  return (auth);     
     }          
 
@Bean      
public Filter chain()        {         
    DurationBasedFilterChainDelegation def = new DurationBasedFilterChainDelegation();              ... // initialize the settings of filter Delegations, e.g., setAuthenticationEntryPoint   and authenticationManager can be used for all properties    
                  return (def);     
 }          
 
}