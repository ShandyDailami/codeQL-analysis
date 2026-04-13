import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_06992_CredentialValidator_A01 {

    private PasswordEncoder passwordEncoder;

    public java_06992_CredentialValidator_A01() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean validateCredentials(String enteredPassword, String storedPassword) {
        return passwordEncoder.matches(enteredPassword, storedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Here you can test the validator. You should replace these with your actual passwords.
        boolean isValid = validator.validateCredentials("testPassword", "$2a$10$EixZ.U.1.I1.WoX3bX3U5Xe.W1sM.6N36W.L1U2.aWdX3.YzVvW");

        System.out.println("Is Valid Credentials: " + isValid);
    }
}