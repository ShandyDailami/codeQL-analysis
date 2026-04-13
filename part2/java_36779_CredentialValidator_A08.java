import java.util.HashMap;
import java.util.Map;

public class java_36779_CredentialValidator_A08 {

    // Define a map to store the credentials
    private Map<String, String> credentials;

    public java_36779_CredentialValidator_A08() {
        // Initialize the credentials map
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the username and password match
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}