import org.springframework.security.authentication.CredentialsNotFoundException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_05681_CredentialValidator_A08 extends DaoAuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public java_05681_CredentialValidator_A08(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails user = userDetailsService.loadUserByUsername(name);

        if (user == null) {
            throw new CredentialsNotFoundException("No user found");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new AuthenticationCredentialsNotFoundException("Credentials not found");
        }

        return new CustomAuthenticationToken(user, password);
    }

    public static class CustomAuthenticationToken extends org.springframework.security.authentication.UsernamePasswordAuthenticationToken {

        private static final long serialVersionUID = 2051920125237698018L;

        public java_05681_CredentialValidator_A08(Object principal, Object credentials) {
            super(principal, credentials);
        }
    }
}