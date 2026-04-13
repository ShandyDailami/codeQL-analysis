import java.util.HashMap;
import java.util.Map;

public class java_04164_CredentialValidator_A03 {
    // Predefined list of users
    private static Map<String, String> users = new HashMap<>();

    // Populate the user list
    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    // Credential validator
    public static boolean validate(String username, String password) {
        // Check if the provided credentials match the stored ones
        return users.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(validate("user1", "password1")); // Should print true
        System.out.println(validate("user4", "password4")); // Should print false
    }
}