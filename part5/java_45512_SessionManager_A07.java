import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.configurers.UserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.UserDeatilsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration   // This is where the application context lives (also known as Spring's IoC container) for your beans, which will be used throughout this example app    
public class java_45512_SessionManager_A07 {    // Defines our spring security configuration properties and Beans in one place. Inheritance chain: App -> [Security] —>> UserDetailsManagerConfigurer  |  HttpSecurity | BCryptPasswordEncoder  |UserDeatilsServiceImpl| userDetailDao    
      
@Bean(name="userBuilder")    //This will be used for creating instances of the classes that are going to use. It is a bean in itself and not an instance, it gets created when required (when any method inside this class calls them)     
public UserDetailsManagerConfigurer<?, ?> userDeatilsService(UserDetailDaoImpl uservalidator){   //Instantiated with Dependency Injection.  This bean will be used for creating instances of the classes that are going to use in our program    
    return new DaoAuthenticationConfigurer<> (uservalid, passwordEncoder());     
}         
@Bean           UserDeatilsServiceImpl userDetailDao(){         //Instantiated with Dependency Injection.   This bean will be used for creating instances of the classes that are going to use in our program     return new  DAOUserDetailsManager();       }    @Bean             BCryptPasswordEncoder passwordEncoder() {       
      Return a PasswordEncoder instance by instantiating it from within another class. This is done via annotations, or manually through code           //Annotated with `@Autowired`          return new BCryptPasswordEncoder();     }    @Bean         HttpSecurity http(HttpInvite userDetailsManager){     
                                                                                                   Spring Security applies several web security filters and supports various protocols. It can be used to configure the authentication process for your application, but only in a context where you’re serving static content from files or resources (i.e., not inside an HTML form).        //Instantiated with Dependency Injection     return http
    .csrf().disable()  // Disables Cross Site Request Forgery Protection and allows more requests to be made, particularly during testing as a security risk   // This is done by calling the method within `HttpInvite` class where you pass it userBuilder      }        @Bean       UserDetailDaoImpl users(){           
                                                                    Return an instance of DAOUserDetailsManager that can retrieve user data. The only thing this does not do here, though - store passwords in plain text for the simplicity (it'll be a huge security risk to actually use such method). It is always recommended you hash and salt your users’password before storing them into db at least on first login after application startup if it supports both stored & hashed.     //Instantiated with Dependency Injection       return new UserDaoImpl();  }
}