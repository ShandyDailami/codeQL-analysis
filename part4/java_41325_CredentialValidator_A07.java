import org.springframework.security.authentication.CredentialsNotFoundException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_41325_CredentialValidator_A07 extends DaoAuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public java_41325_CredentialValidator_A07(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserDetailsService userDetailsService = this.userDetailsService;
        if (userDetailsService == null) {
            throw new IllegalStateException("Cannot proceed with no user details service set");
        }

        try {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            if (passwordEncoder.matches(password, user.getPassword())) {
                return new CustomAuthenticationToken(username, password, user.getAuthorities());
            }
        } catch (UsernameNotFoundException ex) {
            throw new CredentialsNotFoundException("Could not find the username");
        }

        throw new CredentialsNotFoundException("Invalid credentials");
    }

}