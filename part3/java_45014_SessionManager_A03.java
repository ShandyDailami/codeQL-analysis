import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 
@Configuration // It marks the class java_45014_SessionManager_A03 a source of bean definitions for the application context, allowing it to be imported by Spring’s container-aware components like 'Spring Boot'.  
public class SecurityConfig extends WebSecurityConfigurerAdapter {    
      @Override    protected void configure(AuthenticationManagerBuilder auth) throws Exception{         //configure authentication manager builder here          } 
          
@Bean        public UserDetailsService userDetailsService()             {@return new InMemoryUserDetailsManager (              List.of(                User.withUsername("user").passwordEncoder(new BCryptPasswordEncoder()).roles("USER").build(),                   // add more users here         }) ;} }