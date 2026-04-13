import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

public class java_25655_CredentialValidator_A01 {

    private static final String AUTHENTICATION_SCHEME = "Basic";

    public Optional<String> validateCredentials(String user, String password) {
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        // In a real-world scenario, we would not store the passwords in plain text.
        // This is just a placeholder for demonstration purposes.
        String expectedPassword = "expectedPassword";

        // Validate the provided password against the expected password.
        if (!password.equals(expectedPassword)) {
            return Optional.empty();
        }

        // If the password is valid, return an encoded username.
        return Optional.of(Base64.getEncoder().encodeToString((user + ":" + password).getBytes()));
    }
}