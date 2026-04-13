import java.util.HashMap;
import java.util.Map;

public class java_05678_CredentialValidator_A07 {

    // Static map to hold user credentials
    private static Map<String, String> credentials = new HashMap<>();

    // Static block to initialize the credentials
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static boolean authenticate(String username, String password) {
        // If the provided username matches a known username and
        // the provided password matches the known password, return true.
        // Otherwise, return false.
        return (credentials.get(username) != null) &&
                credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Test the authentication process
        if (authenticate("user1", "password1")) {
            System.out.println("User 1 is authenticated successfully.");
        } else {
            System.out.println("Authentication failed for User 1.");
        }

        if (authenticate("user2", "wrongpassword")) {
            System.out.println("User 2 is authenticated successfully.");
        } else {
            System.out.println("Authentication failed for User 2.");
        }
    }
}