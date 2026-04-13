import java.util.HashMap;
import java.util.Map;

public class java_28936_CredentialValidator_A07 {
    // A map to store the users and their passwords
    private static Map<String, String> userMap = new HashMap<>();

    // Initialize the user map
    static {
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    // Credential validator
    public static boolean validate(String username, String password) {
        // Check if the username and password match
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            System.out.println("User authenticated successfully!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        validate("user1", "password1");
        validate("user2", "password2");
        validate("user3", "wrongpassword");
    }
}