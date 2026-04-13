import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration // Define the application as a configuration source, it will be used by Spring to load beans from classpath or elsewhere (Spring Boot)   
public class java_49806_SessionManager_A07 extends WebSecurityConfigurerAdapter {  
     @Override      protected void configure(AuthenticationManagerBuilder auth) throws Exception{         
         BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();          
                 //Store passwords as encrypted strings in the database.      
	auth.inMemoryAuthentication()              .withUser("user").password(bCryptPasswordEncoder               .encode("pass")).roles ("USER");    }         @Override   public void configure(org.springframework.security.config.annotation.web             WebSecurityConfigurer adapter) {      
                 //allow all requests,authenticated users and     anonymous should be allowed only to pages  that are marked as authenticated in the remember me function (secured page).          ...           }    @Bean   public SecurityManager securityManager(){         return new AndOrRemedialSecurityManager();}        }}