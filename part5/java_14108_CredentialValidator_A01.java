import java.util.HashMap;
import java.util.Map;

public class java_14108_CredentialValidator_A01 {

    // Static map of credentials
    private static Map<String, String> credentials = new HashMap<>();

    // Initialize the credentials map
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate the username and password
    public static boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        System.out.println(validateCredentials("user1", "password1")); // Should return true
        System.out.println(validateCredentials("user1", "wrongpassword")); // Should return false
        System.out.println(validateCredentials("nonexistentuser", "anypassword")); // Should return false
    }
}