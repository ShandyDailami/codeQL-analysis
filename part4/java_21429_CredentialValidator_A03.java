import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class java_21429_CredentialValidator_A03 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(AuthenticationProvider provider) {
        provider.setAuthenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) {
                String name = authentication.getName();
                String password = authentication.getCredentials().toString();
                
                if (name.equals("admin") && password.equals("password")) {
                    return new UsernamePasswordAuthenticationToken(name, password, null);
                } else {
                    return null;
                }
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return authentication.equals(UsernamePasswordAuthenticationToken.class);
            }
        });
    }

    // The user details service is used by the DaoAuthenticationProvider to load users from the database.
    @Override
    public void configure(UserDetailsService userDetailsService) {
        userDetailsService.createUserDetails("admin", "password", null);
    }
}