import java.util.HashMap;
import java.util.Map;

public class java_32117_CredentialValidator_A01 {
    // Create a HashMap to store user credentials
    private Map<String, String> credentials = new HashMap<>();

    // Initialize the credential map
    public java_32117_CredentialValidator_A01() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate credentials
    public boolean validateCredentials(String user, String password) {
        // Check if the provided password matches the stored password
        return password.equals(credentials.getOrDefault(user, ""));
    }
}