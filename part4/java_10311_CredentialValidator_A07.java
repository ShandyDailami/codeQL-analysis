import java.util.HashMap;
import java.util.Map;

public class java_10311_CredentialValidator_A07 {

    // Simulate a database for storing users and their passwords
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    public static boolean validateCredentials(String username, String password) {
        // Check if user is in database
        if (userDatabase.containsKey(username)) {
            // Check if password is correct
            if (userDatabase.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        if (validateCredentials("user1", "password1")) {
            System.out.println("Access granted to user1");
        } else {
            System.out.println("Access denied for user1");
        }
        
        if (validateCredentials("user4", "password4")) {
            System.out.println("Access granted to user4");
        } else {
            System.out.println("Access denied for user4");
        }
    }
}