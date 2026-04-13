import java.util.HashMap;
import java.util.Map;

public class java_41716_CredentialValidator_A01 {
    // Define the users
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "password");
        users.put("user", "password");
    }

    // Define the roles
    private static final Map<String, String> roles = new HashMap<>();

    static {
        roles.put("admin", "ROLE_ADMIN");
        roles.put("user", "ROLE_USER");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the user exists
        if (!users.containsKey(username)) {
            throw new RuntimeException("User does not exist!");
        }

        // Check if the password is correct
        if (!users.get(username).equals(password)) {
            throw new RuntimeException("Incorrect password!");
        }

        // Check if the user has the necessary role
        String userRole = roles.get(username);
        if (userRole == null || !userRole.startsWith("ROLE_")) {
            throw new RuntimeException("User does not have the necessary role!");
        }

        // If everything is correct, return true
        return true;
    }
}