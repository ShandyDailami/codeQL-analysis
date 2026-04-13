import java.util.HashMap;
import java.util.Map;

public class java_26916_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_26916_CredentialValidator_A08() {
        // Initialize credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        // If the username and password match our credentials, return true
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        }
        // Otherwise, return false
        return false;
    }
}