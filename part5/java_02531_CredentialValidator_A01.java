import java.util.Objects;
import java.util.HashMap;
import java.util.Map;

public class java_02531_CredentialValidator_A01 {

    // A map to store username-password pairs
    private Map<String, String> users = new HashMap<>();

    // Constructor to initialize the users map
    public java_02531_CredentialValidator_A01() {
        users.put("user1", "password1"); // replace with actual values
        users.put("user2", "password2"); // replace with actual values
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided password matches the hash of the pre-defined password
        // For the sake of example, let's say password1 is hashed to "password1Hash"
        String password1Hash = users.get(username);
        return Objects.hash(username, password) == Objects.hash(username, password1Hash);
    }
}