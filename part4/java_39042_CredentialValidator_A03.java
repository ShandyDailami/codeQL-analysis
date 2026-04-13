import org.springframework.security.authentication.CredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class java_39042_CredentialValidator_A03 extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws CredentialsException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (name.equals("user") && password.equals("password")) {
            return new UsernamePasswordAuthenticationToken(
                    name, password, AuthorityUtils.createAuthorityList("ROLE_USER"));
        } else {
            throw new CredentialsException("Invalid username or password");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        CustomAuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(new org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());

        // Setting authentication provider to spring security
        org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
        org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        org.springframework.beans.factory.annotation.Autowired;

        @Configuration
        protected static class WebSecurityConfigurerAdapter extends org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter {

            @Autowired
            public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.authenticationProvider(authenticationProvider);
            }
        }

        // Creating a user to test
        org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .authorities("ROLE_USER")
                .build();

        // Testing the authentication
        authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken("user", "password"));
    }
}