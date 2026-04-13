import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

public class java_21585_CredentialValidator_A07 {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public java_21585_CredentialValidator_A07(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean validateCredentials(String username, String password) {
        if (!userDetailsManager.userExists(username)) {
            return false;
        }

        String encryptedPassword = userDetailsManager.loadUserByUsername(username).getPassword();

        return passwordEncoder.matches(password, encryptedPassword);
    }
}