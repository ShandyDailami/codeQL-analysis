import java.util.HashMap;
import java.util.Map;

public class java_27490_CredentialValidator_A07 {

    // In-memory database to simulate user database
    private Map<String, String> userDatabase = new HashMap<>();

    // Constructor to initialize the user database
    public java_27490_CredentialValidator_A07() {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        // Check if user exists in the database
        if (userDatabase.containsKey(username)) {
            // Check if the password matches the expected password
            return userDatabase.get(username).equals(password);
        } else {
            // User does not exist in the database
            return false;
        }
    }
}