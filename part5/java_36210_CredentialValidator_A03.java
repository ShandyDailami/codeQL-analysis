import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class java_36210_CredentialValidator_A03 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(javax.servlet.http.HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
            .and()
                .logout()
                    .permitAll();
    }

    @Override
    protected void configure(javax.servlet.http.HttpSecurity http, org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter.RequestCache requestCache) throws Exception {
        http.apply(new org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter.RequestCacheConfig<org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter.RequestMatcher>(requestCache)
        );
    }

    @Override
    public void configure(org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfigurerAdapter<org.springframework.security.config.annotation.web.servlet.configuration.WebSecurityConfigurerAdapter.RequestCache> http) throws Exception {
        http
            .apply(new org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfigurerAdapter<org.springframework.security.config.annotation.web.servlet.configuration.WebSecurityConfigurerAdapter.RequestCache>(http)
        );
    }

    @Override
    public void initialize(org.springframework.security.config.annotation.web.servlet.configuration.WebSecurityConfigurerAdapter.RequestCache requestCache, org.springframework.security.config.annotation.web.servlet.configuration.WebSecurityConfigurerAdapter.HttpSecurityAdapter http, org.springframework.security.config.annotation.web.servlet.configuration.WebSecurityConfigurerAdapter.RequestMatcher matcher) throws Exception {
        http.apply(new org.springframework.security.config.annotation.web.servlet.configuration.WebSecurityConfigurerAdapter.RequestCacheConfig<org.springframework.security.config.annotation.web.servlet.configuration.WebSecurityConfigurerAdapter.RequestMatcher>(requestCache)
        );
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        provider.setUserDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return user;
            }
        });
        return provider;
    }
}