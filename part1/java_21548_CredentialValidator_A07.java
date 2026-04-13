import java.util.HashMap;
import java.util.Map;

public class java_21548_CredentialValidator_A07 {

    // In-memory representation of the database
    private Map<String, String> database = new HashMap<>();

    // Default constructor
    public java_21548_CredentialValidator_A07() {
        // Initialize the database
        database.put("user1", "password1");
        database.put("user2", "password2");
        database.put("user3", "password3");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the user exists in the database
        if (database.containsKey(username)) {
            // Check if the password matches the hashed password in the database
            if (database.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}