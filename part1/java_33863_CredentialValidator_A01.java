import java.util.HashMap;
import java.util.Map;

public class java_33863_CredentialValidator_A01 {
    private static Map<String, String> credentials;

    static {
        // Initialize the credentials.
        credentials = new HashMap<>();
        credentials.put("admin", "password123");
        credentials.put("user1", "user123");
        credentials.put("user2", "user223");
    }

    public static boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the stored credentials.
        return credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("admin", "password123")); // Expected output: true
        System.out.println(validateCredentials("admin", "wrongPassword")); // Expected output: false
   
        System.out.println(validateCredentials("user1", "password123")); // Expected output: false
        System.out.println(validateCredentials("user1", "user123")); // Expected output: true
    }
}