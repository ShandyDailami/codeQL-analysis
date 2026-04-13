import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;   
import org.springframework.security.config.annotation.authentication.EnableGlobalAuthentication;    
import org.springframework.security.config.annotation.web.configuration.WebMvcSecurityConfigurerAdapter;     
  @Configuration   // Define a configuration class java_44391_CredentialValidator_A01 Spring Boot will load this by default if no other annotation is present on the config   
@EnableGlobalAuthentication       // Enable global authentication - so you can use 'secure' instead of '/login'. Also, it requires that your UserDetailsService has been set up and configured. 
public class SecurityConfiguration extends WebMvcSecurityConfigurerAdapter {    
   @Override     
   public void configure(HttpSecurity http) throws Exception{          // This is the method called by Spring Boot - you don't need to call this manually, it will be called automatically        if (authentication != null){            ...             } else  ......    },true);           };              }}                  ',