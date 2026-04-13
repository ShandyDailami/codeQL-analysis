import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class java_08802_CredentialValidator_A08 {

    private final BCryptPasswordEncoder passwordEncoder;

    public java_08802_CredentialValidator_A08() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean validatePassword(String passwordToCheck, String hashedPassword) {
        return passwordEncoder.matches(passwordToCheck, hashedPassword);
    }

    public String hashPassword(String passwordToHash) {
        return passwordEncoder.encode(passwordToHash);
    }
}