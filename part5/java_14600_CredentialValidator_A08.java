import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class java_14600_CredentialValidator_A08 implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here you would typically retrieve the user from your database.
        // However, for simplicity, we'll just return a user with a hardcoded password.
        String password = "{bcrypt}" + BCryptPasswordEncoder.enforce("password", 12);
        return new org.springframework.security.core.userdetails.User(username, password, AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
    
    public boolean validatePassword(String password, UserDetails user) {
        return new BCryptPasswordEncoder().matches(password, user.getPassword());
    }
}

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private MyCredentialValidator credentialValidator;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(credentialValidator);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }
}