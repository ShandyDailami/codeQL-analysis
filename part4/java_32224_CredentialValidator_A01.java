import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsNotFoundException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class java_32224_CredentialValidator_A01 {

    private final UserDetailsService userDetailsService;
    private final DaoAuthenticationProvider daoAuthenticationProvider;

    public java_32224_CredentialValidator_A01(UserDetailsService userDetailsService, DaoAuthenticationProvider daoAuthenticationProvider) {
        this.userDetailsService = userDetailsService;
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    public UsernamePasswordAuthenticationToken validate(String username, String password) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            daoAuthenticationProvider.authenticate(userDetails, password);
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        } catch (UsernameNotFoundException | BadCredentialsException | LockedException | CredentialsNotFoundException e) {
            return null;
        }
    }
}