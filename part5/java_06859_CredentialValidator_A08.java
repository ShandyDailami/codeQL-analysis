import java.util.HashMap;
import java.util.Map;

public class java_06859_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_06859_CredentialValidator_A08() {
        // Hard-coded credentials.
        this.credentials = new HashMap<String, String>() {
            {
                put("admin", "password123");
                put("user1", "user123");
                put("user2", "user222");
            }
        };
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the given credentials match the hard-coded values.
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        }

        return false;
    }
}