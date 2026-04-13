import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration   // This is for Spring Configuration, not required but it simplifies the code a bit by using @Bean annotations in our configuration class java_51050_CredentialValidator_A07 auto wiring those beans into IoC container at runtime   
public class SecurityConfig {     // Not needed if you're only trying to add spring security with no other components or configurations.  
 
@Bean         // This is for Spring Bean, not required but it simplifies the code a bit by using @Autowired annotations in our configuration method and auto wiring those beans into IoC container at runtime   
public SecurityConfig mySecurity() {      return this; }     public HttpSecurity httpSec(HttpSecurity hs) throws Exception{  // This is for Spring HTTP, not required but it simplifies the code a bit by using @Autowired annotations in our configuration method and auto wiring those beans into IoC container at runtime  
        Customizer<? super HtmlHeap> c=null;hs.headers(c->{ });  hs =hudson .authenticatedSession();     //This sets up Authentication for the user, not required but it simplifies code by using Spring Security features    return null;}     
   }public static void main (String [] args){}       public BCryptPasswordEncoder bCrypt(){return new  BcryptPassword Encoder() ;}};`     // This is to provide a password encryption mechanism. Without the use of external libraries, it will be quite complex and outdated code which we are not using any spring security features or methods in this program at all!