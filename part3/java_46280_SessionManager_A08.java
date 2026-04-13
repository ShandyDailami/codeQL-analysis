import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
   
@Configuration     // annotation for spring configuration class java_46280_SessionManager_A08 bean definition xml file 
public class SecurityConfig extends WebSecurityConfigurerAdapter {  
      @Override       // Method to configure the security of request chain with http object, HttpServletRequest and Response objects in case a user is authenticated. In this example we only allow access "/securepage".    public void doFilter(HttpServletRequest req, 
                                                                          ServletResponse res, FilterChain chain) throws IOException, ServletException {   // here you can add your custom logic for authentication... }     @Autowired       private UserDetailsService userDetailsService;      protected void configure(AuthenticationManagerBuilder auth) throws Exception {}    public static final String SECURE_PAGE = "/securepage";