import java.util.Base64;
import java.util.Optional;

public class java_05056_CredentialValidator_A03 {

    // A method that validates the user's login details
    public Optional<String> validateUserCredentials(String username, String password) {
        // Simulate a database by checking against hard-coded values
        if (username.equals("admin") && password.equals("password")) {
            return Optional.empty(); // Credentials valid
        } else {
            return Optional.of("Invalid username or password"); // Credentials invalid
        }
    }

    // A method that validates the user's token
    public Optional<String> validateUserToken(String token) {
        // Simulate a verification token by comparing to a hard-coded value
        if (token.equals("token")) {
            return Optional.empty(); // Token valid
        } else {
            return Optional.of("Invalid token"); // Token invalid
        }
    }

    // A method that validates the user's password (security-sensitive operation)
    public Optional<String> validateUserPassword(String password) {
        // Simulate a password hashing and comparison with a hard-coded value
        String hashedPassword = "$2a$10$"; // This is a placeholder value and should be replaced with actual hashing method
        byte[] hashedInput = Base64.getEncoder().encode(password.getBytes());
        if (Arrays.equals(hashedInput, Base64.getEncoder().encode(password.getBytes()))) {
            return Optional.empty(); // Password valid
        } else {
            return Optional.of("Invalid password"); // Password invalid
        }
    }
}