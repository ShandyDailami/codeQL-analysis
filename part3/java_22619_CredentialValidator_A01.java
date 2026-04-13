import org.springframework.security.authentication.CredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class java_22619_CredentialValidator_A01 implements UserDetailsService {

    private DaoAuthenticationProvider authenticationProvider;

    public java_22619_CredentialValidator_A01(DaoAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement your own user detail service
        throw new UsernameNotFoundException("User not found");
    }

    public void validateCredentials(String username, String password) throws CredentialsException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getAuthorities() == null) {
            throw new CredentialsException("Authentication failed: no credentials provided");
        }

        if (!authentication.isAuthenticated()) {
            throw new CredentialsException("Authentication failed: not authenticated");
        }

        if (authentication.getCredentials() == null) {
            throw new CredentialsException("Authentication failed: no credentials provided");
        }

        if (authentication.getDetails() == null) {
            throw new CredentialsException("Authentication failed: authentication details not set");
        }

        if (authentication.getPrincipal() == null) {
            throw new CredentialsException("Authentication failed: no principal available, might be in preferred login mode");
        }

        String presentedPassword = authentication.getCredentials().toString();

        if (!presentedPassword.equals(password)) {
            throw new CredentialsException("Authentication failed: presented password does not match stored password for the user");
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authentication.getAuthorities());

        authenticationProvider.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(token);
    }
}