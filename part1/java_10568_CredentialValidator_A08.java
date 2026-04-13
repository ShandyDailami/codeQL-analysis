import java.util.Arrays;
import java.util.List;

public class java_10568_CredentialValidator_A08 {
    // List of allowed usernames
    private static final List<String> ALLOWED_USERNAMES = Arrays.asList("admin", "user1", "user2", "user3");

    // List of allowed passwords (in plain text form)
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("admin123", "user123", "user321");

    // Method to validate the username and password
    public static boolean validate(String username, String password) {
        if (ALLOWED_USERNAMES.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(validate("admin", "admin123")); // Should print true
        System.out.println(validate("admin", "invalid")); // Should print false
        System.out.println(validate("user1", "user123")); // Should print true
        System.out.println(validate("user1", "invalid")); // Should print false
    }
}