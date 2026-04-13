import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.dao.*;
 
@EnableWebSecurity(proxyTargetClass=true) // Enable web security for Spring MVC (Spring Security is a framework of itself, so it must be enabled at the same level as its core features).  
public class java_49651_CredentialValidator_A01 extends org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter { 
     @Override protected void configure(HttpSecurity http) throws Exception{    // Override method to customize HTTP security ie, configuring the HttpRequests (GET and POST).   }      private UserDetailsService userDetailsService(){       return new InMemoryUserDetailsManager(          // create users for in-memory authentication 
        		User.withDefaultPasswordEncoder()                                 			// using BCrypt encoded password    .username("user")    				.password("{noop}pass1234").roles("USER")           									      /* other user roles here */); }}   // end of private UserDetailsService method      
  @Bean public DaoAuthenticationProvider daoAuthenticationProvider() {        return new DaoAuthenticationProvider().setPasswordEncoder(new BCryptPasswordEncoder()). setUserDetailsService (userDetailsService()); }          protected void configure(AuthenticationManagerBuilder auth) throws Exception{      // Configure the Authentication Manager to use our Custom User Details Service and passwords encoded by ’BCrypt.