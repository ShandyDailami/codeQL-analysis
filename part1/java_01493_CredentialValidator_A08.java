import java.util.HashMap;
import java.util.Map;

public class java_01493_CredentialValidator_A08 {

    // HashMap to store credentials
    private Map<String, String> credentials;

    public java_01493_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the stored credentials
        return (this.credentials.get(username).equals(password));
    }
}