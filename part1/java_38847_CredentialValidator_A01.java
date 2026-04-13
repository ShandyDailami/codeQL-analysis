import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class java_38847_CredentialValidator_A01 {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public static Optional<String> validate(String username, String password) {
        if (!username.equals(ADMIN_USERNAME) || !password.equals(ADMIN_PASSWORD)) {
            return Optional.of("Invalid username or password");
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        Optional<String> result = validate("admin", "password");
        if (result.isPresent()) {
            System.out.println("Error: " + result.get());
        } else {
            System.out.println("Access granted");
        }
    }
}