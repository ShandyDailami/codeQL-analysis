import java.util.HashMap;
import java.util.Map;

public class java_41961_CredentialValidator_A07 {

    // This is our "database" of known users.
    // In a real-world application, this would be loaded from a database.
    private static final Map<String, String> knownUsers = new HashMap<>();

    static {
        knownUsers.put("user1", "password1");
        knownUsers.put("user2", "password2");
        knownUsers.put("user3", "password3");
    }

    // This is our validator method.
    public static boolean validate(String username, String password) {
        // Check if the user exists in the database.
        if (knownUsers.containsKey(username)) {
            // Check if the password is correct.
            if (knownUsers.get(username).equals(password)) {
                return true;
            }
        }
        // If the user doesn't exist or the password is incorrect, return false.
        return false;
    }

    public static void main(String[] args) {
        // Test the validator.
        System.out.println(validate("user1", "password1")); // true
        System.out.println(validate("user1", "wrongpassword")); // false
        System.out.println(validate("nonExistentUser", "password")); // false
    }
}