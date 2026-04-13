import java.util.HashMap;
import java.util.Map;

public class java_09992_CredentialValidator_A01 {

    // Create a HashMap to store user credentials
    private Map<String, String> credentials = new HashMap<>();

    // Add some test users
    public java_09992_CredentialValidator_A01() {
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    // A method that validates a user's credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided password matches the stored password for the user
        return password.equals(credentials.get(username));
    }

    // A method that checks if a user is authenticated
    public boolean isUserAuthenticated(String username) {
        // Check if the user is in our credentials map
        return credentials.containsKey(username);
    }
}

// Usage:
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to access a system resource
        if (validator.isUserAuthenticated("admin")) {
            System.out.println("Access granted to 'admin'");
        } else {
            System.out.println("Access denied. Invalid credentials");
        }

        if (validator.isUserAuthenticated("user1")) {
            System.out.println("Access granted to 'user1'");
        } else {
            System.out.println("Access denied. Invalid credentials");
        }
    }
}