import java.util.Base64;
import java.util.Optional;

public class java_25651_CredentialValidator_A01 {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public static Optional<String> validateCredentials(String username, String password) {
        if (areValidCredentials(username, password)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }

    private static boolean areValidCredentials(String username, String password) {
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    public static void main(String[] args) {
        Optional<String> errorMessage = validateCredentials("invalid", "username");
        if (errorMessage.isPresent()) {
            System.out.println(errorMessage.get());
        } else {
            System.out.println("Access granted");
        }
    }
}