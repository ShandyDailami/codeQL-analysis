import java.util.HashMap;
import java.util.Map;

public class java_15752_CredentialValidator_A08 {

    // Hard-coded credentials
    private static final Map<String, String> credentials = new HashMap<>();

    // Initialize the hard-coded credentials
    static {
        credentials.put("admin", "password123");
        credentials.put("user1", "password123");
    }

    public static boolean validateCredentials(String username, String password) {
        // If the username and password match one of the hard-coded credentials
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the credentials validator
        System.out.println(validateCredentials("admin", "password123")); // true
        System.out.println(validateCredentials("user1", "password123")); // true
        System.out.println(validateCredentials("user1", "wrongpassword")); // false
        System.out.println(validateCredentials("nonexistentuser", "password")); // false
    }
}