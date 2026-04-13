import java.util.HashMap;
import java.util.Map;

public class java_08406_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_08406_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        // Add some dummy credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}