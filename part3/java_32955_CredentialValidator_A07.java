import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class java_32955_CredentialValidator_A07 extends DaoAuthenticationProvider {

    private final UserDetailsService userDetailsService;

    public java_32955_CredentialValidator_A07(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetailsService userDetailsService = this.userDetailsService;
        if (!(userDetailsService instanceof UserDetailsService)) {
            throw new IllegalArgumentException("UserDetailsService implementation not found");
        }

        if (!((UserDetailsService) userDetailsService).loadUserByUsername(username).getPassword().equals(password)) {
            throw new AuthenticationException("Authentication failed") {
            };
        }

        return new CustomAuthenticationToken(username, password, (UserDetails) ((UserDetailsService) userDetailsService).loadUserByUsername(username));
    }
}