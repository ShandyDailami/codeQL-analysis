import java.util.HashMap;
import java.util.Map;

public class java_04464_CredentialValidator_A07 {
    // A simple map to store the credentials.
    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Initialize the credentials map.
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static boolean validateCredentials(String username, String password) {
        // Check if the given credentials match with stored ones.
        return credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Test the credentials validator.
        if (validateCredentials("user1", "password1")) {
            System.out.println("Access granted to user1");
        } else {
            System.out.println("Access denied for user1");
        }

        if (validateCredentials("user2", "wrongpassword")) {
            System.out.println("Access granted to user2");
        } else {
            System.out.println("Access denied for user2");
        }

        if (validateCredentials("nonexistentuser", "nonexistentpassword")) {
            System.out.println("Access granted for nonexistent user");
        } else {
            System.out.println("Access denied for nonexistent user");
        }
    }
}