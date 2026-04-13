import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_17825_CredentialValidator_A03 {

    // Create a map to store the credentials
    private static Map<String, String> credentials = new HashMap<>();

    // Add credentials to the map
    public static void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        credentials.put(username, encryptedPassword);
    }

    // Validate a username and password
    public static boolean validateCredential(String username, String password) {
        if (credentials.containsKey(username)) {
            String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
            return credentials.get(username).equals(encryptedPassword);
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        addCredential("user1", "password1");
        addCredential("user2", "password2");

        System.out.println(validateCredential("user1", "password1")); // Should print: true
        System.out.println(validateCredential("user3", "password1")); // Should print: false
        System.out.println(validateCredential("user1", "wrongpassword")); // Should print: false
    }
}