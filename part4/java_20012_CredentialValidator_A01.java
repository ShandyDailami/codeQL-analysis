import java.util.HashMap;
import java.util.Map;

public class java_20012_CredentialValidator_A01 {
    // Create a map for storing user credentials
    private Map<String, String> userCredentials;

    public java_20012_CredentialValidator_A01() {
        userCredentials = new HashMap<>();
        // Add some default users and passwords for testing
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        // Check if the entered credentials match the stored ones
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}