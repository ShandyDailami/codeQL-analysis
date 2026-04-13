import java.util.HashMap;
import java.util.Map;

public class java_19574_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_19574_CredentialValidator_A07() {
        // Create a map to store user credentials
        credentials = new HashMap<>();
        // Add some dummy data
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the given username and password match those in our map
        return credentials.get(username).equals(password);
    }
}