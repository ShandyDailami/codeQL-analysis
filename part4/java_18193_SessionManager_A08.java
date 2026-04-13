// Import necessary packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class java_18193_SessionManager_A08 {
    // Inject the session manager into the service
    @Autowired
    private SessionManager sessionManager;

    // Use the session manager to perform security-sensitive operations
    @Transactional
    public void doSecuritySensitiveOperation() {
        // Perform some security-sensitive operation...
    }

    // Check if the current user is authenticated
    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken);
    }
}

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Inject the security service into the configuration
    @Autowired
    private SecurityService securityService;

    // Configure the security settings
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**", "/css/**", "/js/**", "/images/**");
    }

    // Configure the authentication settings
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")
                .failureURL("/login?error=true")
                .defaultSuccessURL("/home", true);

        http.logout()
                .logoutSuccessUrl("/login")
                .clearAuthentication(true);
    }
}

@Controller
public class SecurityController {
    // Inject the security service into the controller
    @Autowired
    private SecurityService securityService;

    @RequestMapping("/home")
    public String home() {
        // Check if the user is authenticated
        if (securityService.isAuthenticated()) {
            // Perform security-sensitive operation...
            securityService.doSecuritySensitiveOperation();
        } else {
            // Redirect to login page
            return "redirect:/login";
        }

        return "home";
    }
}