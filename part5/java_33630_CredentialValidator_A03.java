import org.springframework.security.authentication.CredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class java_33630_CredentialValidator_A03 {

    private final UserDetailsService userDetailsService;
    private final DaoAuthenticationProvider daoAuthenticationProvider;

    public java_33630_CredentialValidator_A03(UserDetailsService userDetailsService, DaoAuthenticationProvider daoAuthenticationProvider) {
        this.userDetailsService = userDetailsService;
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    public String authenticate(String username, String password) {
        Authentication authentication = daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        if (authentication.isAuthenticated()) {
            return "Authenticated successfully";
        } else {
            throw new CredentialsNotFoundException("Invalid credentials");
        }
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsService.loadUserByUsername(username);
    }
}