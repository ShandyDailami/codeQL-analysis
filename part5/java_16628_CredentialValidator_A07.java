import java.util.Base64;
import java.util.Optional;

public class java_16628_CredentialValidator_A07 {

    // This is just a simple example. In reality, the credentials should be stored in a database.
    private static final String EXPECTED_CREDENTIALS = "admin:admin";

    public Optional<String> validate(String username, String password) {
        // Convert the credentials into Base64
        String expectedCredentials = Base64.getEncoder().encodeToString(EXPECTED_CREDENTIALS.getBytes());
        String providedCredentials = Base64.getEncoder().encodeToString(password.getBytes());

        // Compare the expected and provided credentials
        if (expectedCredentials.equals(providedCredentials)) {
            return Optional.empty(); // No error
        } else {
            return Optional.of("Invalid username or password"); // Error
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        Optional<String> error = validator.validate("admin", "admin");
        if (error.isPresent()) {
            System.out.println(error.get());
        } else {
            System.out.println("Valid credentials");
        }

        // Test invalid credentials
        error = validator.validate("admin", "wrongpassword");
        if (error.isPresent()) {
            System.out.println(error.get());
        } else {
            System.out.println("Valid credentials");
        }
    }
}