import java.util.HashMap;
import java.util.Map;

public class java_38671_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_38671_CredentialValidator_A01() {
        credentials = new HashMap<>();
        // Add some default credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password are valid
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}