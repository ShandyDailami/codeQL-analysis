import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;

public class java_36340_CredentialValidator_A01 {

    // Define the expected username and password
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("admin", "password");
        users.put("alice", "alice");
        users.put("bob", "bob");
    }

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Using a simple comparison, not recommended for production use
        if (!username.equals(EXPECTED_USERNAME) || !password.equals(EXPECTED_PASSWORD)) {
            return false;
        }

        // Verifying the password
        if (password.length() < 8 || !password.matches(".*[0-9].*") || !password.matches(".*[a-zA-Z].*")) {
            return false;
        }

        // If all checks passed, return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "password")); // Should print true
        System.out.println(validate("admin", "wrongpassword")); // Should print false
        System.out.println(validate("alice", "alice")); // Should print true
        System.out.println(validate("alice", "wrongpassword")); // Should print false
        System.out.println(validate("bob", "bob")); // Should print true
        System.out.println(validate("bob", "wrongpassword")); // Should print false
        System.out.println(validate("charlie", "charlie")); // Should print false
    }
}