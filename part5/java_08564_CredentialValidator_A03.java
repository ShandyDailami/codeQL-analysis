import java.util.HashMap;
import java.util.Map;

public class java_08564_CredentialValidator_A03 {
    // Define a map to store usernames and passwords
    private Map<String, String> credentialMap;

    // Constructor to initialize the credentialMap
    public java_08564_CredentialValidator_A03() {
        credentialMap = new HashMap<>();
        // Add some dummy credentials to the map
        credentialMap.put("admin", "password");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // If the username and password match in the map, return true
        // Otherwise, return false
        return credentialMap.get(username).equals(password);
    }
}