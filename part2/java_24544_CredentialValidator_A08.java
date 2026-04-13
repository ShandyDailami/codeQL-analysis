import java.util.HashMap;
import java.util.Map;

public class java_24544_CredentialValidator_A08 {

    // Simulate a database of users with their hashed passwords
    private Map<String, String> userDatabase;

    public java_24544_CredentialValidator_A08() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1"); // For testing purposes
        userDatabase.put("user2", "password2");
    }

    // Method to validate user credentials
    public boolean validateUserCredentials(String user, String password) {
        if (userDatabase.containsKey(user) && userDatabase.get(user).equals(password)) {
            return true; // Credentials are correct
        } else {
            return false; // Credentials are incorrect
        }
    }
}