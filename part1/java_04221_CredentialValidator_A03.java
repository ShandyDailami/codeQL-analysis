import java.util.HashMap;
import java.util.Map;

public class java_04221_CredentialValidator_A03 {

    // Pre-defined credentials
    private static Map<String, String> credentials = new HashMap<String, String>() {
        {
            put("admin", "password123");
            put("user1", "password123");
            put("user2", "password123");
        }
    };

    public static boolean validate(String username, String password) {
        // Check if the username and password are in the known credentials
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }

    public static void main(String[] args) {
        // Testing
        validate("admin", "password123");
        validate("user1", "password123");
        validate("invalid", "invalid");
    }
}