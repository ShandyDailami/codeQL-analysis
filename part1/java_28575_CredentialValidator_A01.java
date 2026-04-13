import java.util.HashMap;
import java.util.Map;

public class java_28575_CredentialValidator_A01 {
    // Store the credentials in a Map
    private Map<String, String> credentials;

    // Constructor
    public java_28575_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    // Method to add a credential
    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    // Method to validate a credential
    public boolean validateCredential(String username, String password) {
        // Check if the Map contains the username and password
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(password);
    }
}