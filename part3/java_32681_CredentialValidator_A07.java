import java.util.HashMap;
import java.util.Map;

public class java_32681_CredentialValidator_A07 {
    // Using a HashMap to store username and password
    private Map<String, String> credentials;

    public java_32681_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the username and password exist in the map
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }
}