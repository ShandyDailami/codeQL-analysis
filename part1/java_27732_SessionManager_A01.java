import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

@Configuration
@EnableJdbcHttpSession
@EnableSpringHttpSession
@EnableWebSecurity
public class java_27732_SessionManager_A01 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessURL("/home")
            .and()
                .logout()
                .logoutSuccessURL("/logout")
            .and()
                .sessionManagement()
                .maximumSessions(2)
                .expireSeconds(10);
    }

    @Bean
    public SpringSessionRepository springSessionRepository() {
        return new SpringSessionRepository();
    }

    private class SpringSessionRepository {
        // empty because we are not using Spring's database
    }
}