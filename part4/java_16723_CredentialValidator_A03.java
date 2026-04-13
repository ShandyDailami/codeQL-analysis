import java.util.HashMap;
import java.util.Map;

public class java_16723_CredentialValidator_A03 {

    // Predefined credentials
    private static Map<String, String> predefinedCredentials = new HashMap<>();

    // Initialize the predefined credentials
    static {
        predefinedCredentials.put("user1", "password1");
        predefinedCredentials.put("user2", "password2");
        predefinedCredentials.put("user3", "password3");
    }

    // Method to validate credentials
    public static boolean validateCredentials(String username, String password) {
        // If the username and password match one of the predefined credentials, return true
        return predefinedCredentials.containsKey(username)
                && predefinedCredentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        System.out.println(validateCredentials("user1", "password1")); // true
        System.out.println(validateCredentials("user1", "wrongpassword")); // false
        System.out.println(validateCredentials("unknownuser", "password")); // false
    }
}