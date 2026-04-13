import java.util.HashMap;
import java.util.Map;

public class java_24021_CredentialValidator_A03 {
    // A map to store user credentials.
    private Map<String, String> credentials;

    public java_24021_CredentialValidator_A03() {
        // Initialize the credentials map.
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method to validate user credentials.
    public boolean validate(String user, String password) {
        // Check if the credentials map contains the provided username and password.
        return this.credentials.containsKey(user) && this.credentials.get(user).equals(password);
    }
}