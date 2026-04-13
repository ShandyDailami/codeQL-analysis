import java.util.Base64;
import java.util.HashMap;

public class java_13771_CredentialValidator_A03 {

    // Define a HashMap to store username and password
    private HashMap<String, String> credentials;

    public java_13771_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        // Add more users if required
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // If the username exists in the HashMap
        if (this.credentials.containsKey(username)) {
            // If the password matches the one in the HashMap
            if (this.credentials.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}