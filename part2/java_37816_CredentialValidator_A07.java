import java.util.HashMap;
import java.util.Map;

public class java_37816_CredentialValidator_A07 {

    // Storing users in a map
    private static Map<String, String> users = new HashMap<>();

    static {
        // Adding users to the map
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public static boolean validate(String username, String password) {
        // If username and password matches, return true
        return users.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Test the validate method
        System.out.println(validate("user1", "password1")); // Expected output: true
        System.out.println(validate("user1", "wrongpassword")); // Expected output: false
        System.out.println(validate("nonexistentuser", "nonexistentpassword")); // Expected output: false
    }
}