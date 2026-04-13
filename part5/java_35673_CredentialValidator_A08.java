import java.util.HashMap;
import java.util.Map;

public class java_35673_CredentialValidator_A08 {
    // Use a map to hold user credentials for simplicity
    private Map<String, String> userCredentials;

    // Constructor
    public java_35673_CredentialValidator_A08() {
        userCredentials = new HashMap<>();
        // Add some dummy users
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    // Method to validate a user's login credentials
    public boolean validateCredentials(String user, String password) {
        // Check if the user exists in the database
        if (userCredentials.containsKey(user)) {
            // Check if the password is correct
            if (userCredentials.get(user).equals(password)) {
                return true;
            }
        }
        return false;
    }
}