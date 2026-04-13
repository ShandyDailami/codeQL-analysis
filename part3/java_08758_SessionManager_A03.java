import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@ComponentScan(basePackages = "com.example")
public class java_08758_SessionManager_A03 {

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .addFilterBefore(authenticationFilter(), BasicAuthenticationFilter.class);
            }

            @Bean
            public AuthenticationFilter authenticationFilter() {
                return new AuthenticationFilter();
            }
        };
    }

    @Controller
    public class AuthenticationFilter extends BasicAuthenticationFilter {

        @Override
        protected boolean supports(Class authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }

        @Override
        protected Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
    }
}