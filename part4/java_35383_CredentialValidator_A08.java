import java.util.Base64;
import java.util.Optional;

public class java_35383_CredentialValidator_A08 {

    // Method to validate a credential
    public Optional<String> validate(String user, String password) {
        // For simplicity, we'll assume a simple username-password check.
        // In a real-world scenario, this would be hashed and salted passwords.
        if ("admin".equals(user) && "password".equals(password)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        Optional<String> result = validator.validate("admin", "password");
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Access granted");
        }
    }
}