import java.util.HashMap;
import java.util.Map;

public class java_17576_CredentialValidator_A01 {

    // A dummy database of username/password pairs.
    private static Map<String, String> database = new HashMap<>();

    static {
        database.put("admin", "password123");
        database.put("user1", "password123");
        database.put("user2", "password123");
    }

    // Method to authenticate a user.
    public boolean authenticate(String username, String password) {
        return (database.get(username) != null && database.get(username).equals(password));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Authenticate user.
        boolean isAuthenticated = validator.authenticate("admin", "password123");
        if (isAuthenticated) {
            System.out.println("Access granted, welcome admin!");
        } else {
            System.out.println("Access denied, please try again.");
        }

        isAuthenticated = validator.authenticate("user1", "password123");
        if (isAuthenticated) {
            System.out.println("Access granted, welcome user!");
        } else {
            System.out.println("Access denied, please try again.");
        }
    }
}