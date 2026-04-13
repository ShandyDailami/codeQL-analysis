import java.util.HashMap;
import java.util.Map;

public class java_27648_CredentialValidator_A07 {

    // Use a Map to store user credentials
    private Map<String, String> credentials;

    // Initialize the credentials map
    public java_27648_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate the user credentials
    public boolean validateCredentials(String user, String password) {
        // Check if the provided password matches the expected password
        return this.credentials.get(user).equals(password);
    }

}