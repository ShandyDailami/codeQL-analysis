import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 
@Configuration
@EnableWebSecurity   // Enables Spring Security and configures it to auto-configure other things like security configuration, form login etc. in an annotation @EnableWebSecurity is added here by default so no need for additional configurations apart from adding beans or enabling web mvc context as shown below: 
public class java_52395_SessionManager_A03 {   //Example Spring MVC Configuration Class begins    }//example spring security configuration ends     public static void main(String[] args) throws Exception{        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();ctx.register(SecurityConfiguration.class);        
tx.refresh(); SecurityUserDetailsService userDetailsService;  @Bean User.Builder getUserBuilder(){ return User.withDefaultPasswordEncoder();}@Autowired public void setDataSource(@Qualifier("dataSource") DataSource dataSource){userRepository=new JdbcUserRepository(ds);}}//example spring mvc configuration begins
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {  //Example Spring MVC Configuration Class continues    private UserDetailsService userDetailsService;@Autowired public void setDataSource(@Qualifier("dataSource") DataSource dataSource){userRepository=new JdbcUserRepository(ds);}}//example spring mvc configuration ends