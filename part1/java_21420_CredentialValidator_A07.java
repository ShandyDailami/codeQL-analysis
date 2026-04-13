import java.util.HashMap;
import java.util.Map;

public class java_21420_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_21420_CredentialValidator_A07() {
        // Initialize the map of credentials
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match a stored one
        String storedPassword = this.credentials.get(username);
        return password.equals(storedPassword);
    }
}