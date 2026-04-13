import java.util.HashMap;
import java.util.Map;

public class java_14295_CredentialValidator_A01 {
    // A map to hold the allowed usernames and passwords
    private Map<String, String> allowedUsers;

    // Constructor to initialize the allowed users
    public java_14295_CredentialValidator_A01() {
        allowedUsers = new HashMap<>();
        allowedUsers.put("user1", "password1");
        allowedUsers.put("user2", "password2");
        allowedUsers.put("user3", "password3");
    }

    // Method to validate the username and password
    public boolean validateCredentials(String username, String password) {
        // If the username and password match one of the allowed users, return true
        if (allowedUsers.containsKey(username) && allowedUsers.get(username).equals(password)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }
}