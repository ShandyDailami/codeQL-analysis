import org.springframework.security.authentication.CredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class java_10661_CredentialValidator_A03 {

    private final UserDetailsService userDetailsService;

    public java_10661_CredentialValidator_A03(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public Authentication validate(String username, String password) {
        UserDetails user;
        try {
            user = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException ex) {
            throw new CredentialsNotFoundException("User not found!");
        }

        return checkPassword(user, password);
    }

    private Authentication checkPassword(UserDetails user, String password) {
        if (user.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
        } else {
            throw new CredentialsNotFoundException("Invalid password!");
        }
    }
}