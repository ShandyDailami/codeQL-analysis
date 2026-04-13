import java.util.HashMap;
import java.util.Map;

public class java_05613_CredentialValidator_A08 {

    // Create a map to store usernames and passwords
    private Map<String, String> credentials;

    public java_05613_CredentialValidator_A08() {
        // Initialize the map
        credentials = new HashMap<>();

        // Add some sample credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match with the ones in the map
        return credentials.get(username).equals(password);
    }
}