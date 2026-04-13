import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_36771_CredentialValidator_A03 {

    private final PasswordEncoder passwordEncoder;

    public java_36771_CredentialValidator_A03() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean validateCredentials(String presentedPassword, String storedPassword) {
        return passwordEncoder.matches(presentedPassword, storedPassword);
    }

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}