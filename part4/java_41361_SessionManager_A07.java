import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@EnableWebSecurity
public class java_41361_SessionManager_A07 extends WebSecurityConfigurerAdapter {

    private UserDetailsManager userDetailsManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(authenticationFilter(), ChannelProcessingFilter.class)
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").permitAll()
            .and()
            .logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDetails user = User.withUsername("user").password(encoder.encode("password")).roles("USER").build();
        UserDetails admin = User.withUsername("admin").password(encoder.encode("password")).roles("USER", "ADMIN").build();

        userDetailsManager = new InMemoryUserDetailsManager(user, admin);

        auth.userDetailsService(userDetailsManager).passwordEncoder(encoder);
    }

    private class AuthenticationFilter extends BasicAuthenticationFilter {

        public java_41361_SessionManager_A07(AuthenticationManager authenticationManager) {
            super(authenticationManager);
        }

        @Override
        protected Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

            return getAuthenticationManager().authenticate(authenticationToken);
        }
    }

    private AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter(authenticationManager());
    }
}