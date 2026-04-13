import java.util.HashMap;
import java.util.Map;

public class java_21592_CredentialValidator_A03 {

    // A map that holds usernames and passwords for demonstration purposes
    private static Map<String, String> userMap = new HashMap<>();

    static {
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    // Credential validation method
    public static boolean validateCredentials(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        boolean result = validateCredentials("user1", "password1");
        if (result) {
            System.out.println("Access granted for user: user1");
        } else {
            System.out.println("Access denied for user: user1");
        }

        result = validateCredentials("user4", "password4");
        if (result) {
            System.out.println("Access granted for user: user4");
        } else {
            System.out.println("Access denied for user: user4");
        }
    }
}