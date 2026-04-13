import java.util.HashMap;
import java.util.Map;

public class java_20847_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_20847_CredentialValidator_A03() {
        // Hard-coded credentials
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided credentials match the hard-coded credentials
        if (this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}