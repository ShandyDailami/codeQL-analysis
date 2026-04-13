import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@Configuration
// Enable Spring Data JPA Repository and Http Session in project's configuration class java_51936_SessionManager_A08, 
// which are required for session management by spring-security using @RepositoryRestController annotation & extends WebMvcConfigurerAdapter - not used here as it is already mentioned.  
@EnableJpaRepositories("com.example.*") // Specify packages to scan repository in application context, change accordingly 
// Enable Spring Session with HttpSession for session management by spring-security using @Configuration and extends WebMvcConfigurerAdapter - not used here as it is already mentioned & will have security constraints enforced via the HTTP request.  
@EnableSpringHttpSession(maxInactiveInterval = 3600) // Specify how long a user should be allowed to remain in session, change according need  (in seconds).   
public class SessionManagerConfiguration { }