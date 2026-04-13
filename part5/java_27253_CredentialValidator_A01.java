import java.util.HashMap;
import java.util.Map;

public class java_27253_CredentialValidator_A01 {

    // In-memory data structure for storing user credentials.
    private Map<String, String> credentials;

    public java_27253_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Compare the provided password with the stored password.
        String storedPassword = this.credentials.get(username);
        return password.equals(storedPassword);
    }
}