import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_24148_CredentialValidator_A03 {
    private PasswordEncoder passwordEncoder;

    public java_24148_CredentialValidator_A03() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean validateCredentials(String providedPassword, String storedPassword) {
        return passwordEncoder.matches(providedPassword, storedPassword);
    }

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}