import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_39157_CredentialValidator_A03 {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    public java_39157_CredentialValidator_A03(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean validateCredentials(String username, String password) {
        try {
            userDetailsService.loadUserByUsername(username);
            return passwordEncoder.matches(password, ((DaoAuthenticationProvider) userDetailsService).getPasswordEncoder().encode(password));
        } catch (UsernameNotFoundException e) {
            return false;
        }
    }
}