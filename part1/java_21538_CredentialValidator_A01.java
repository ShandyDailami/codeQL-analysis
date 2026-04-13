import org.springframework.security.authentication.CredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class java_21538_CredentialValidator_A01 extends DaoAuthenticationProvider {

    private final UserDetailsService userDetailsService;

    public java_21538_CredentialValidator_A01(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails user = userDetailsService.loadUserByUsername(name);

        if (user == null) {
            throw new CredentialsException("User not found");
        }

        if (!passwordEncoder().matches(password, user.getPassword())) {
            throw new CredentialsException("Bad credentials");
        }

        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }

}