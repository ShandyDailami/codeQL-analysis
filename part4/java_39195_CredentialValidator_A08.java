import java.util.Base64;
import java.util.Optional;

public class java_39195_CredentialValidator_A08 {

    // Simulate the username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static Optional<String> validateCredentials(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        Optional<String> errorMessage = validateCredentials("wrongUsername", "wrongPassword");
        if (errorMessage.isPresent()) {
            System.out.println("Error: " + errorMessage.get());
        } else {
            System.out.println("Login successful!");
        }
    }
}