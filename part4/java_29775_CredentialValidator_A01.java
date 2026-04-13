import java.util.Base64;
import java.util.Optional;

public class java_29775_CredentialValidator_A01 {

    // In a real-world scenario, we should use a more secure way to store and compare passwords
    private static final String STORED_PASSWORD = "$2a$10$"; // Encoded string of a password

    public Optional<String> validateCredentials(String userName, String password) {
        // In a real-world scenario, we should compare the stored password with a hashed version of the provided password
        if (userName.equals("admin") && STORED_PASSWORD.equals(hashPassword(password))) {
            return Optional.of("User authenticated successfully");
        } else {
            return Optional.empty();
        }
    }

    private String hashPassword(String password) {
        // In a real-world scenario, we should use a more secure way to hash passwords
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}