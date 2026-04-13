import java.util.HashMap;
import java.util.Map;

public class java_26729_CredentialValidator_A01 {
    // A map to store user credentials
    private Map<String, String> credentialMap;

    // Constructor
    public java_26729_CredentialValidator_A01() {
        this.credentialMap = new HashMap<>();

        // Add predefined credentials
        this.credentialMap.put("user1", "password1");
        this.credentialMap.put("user2", "password2");
        this.credentialMap.put("user3", "password3");
    }

    // Method to validate the username and password
    public boolean validateCredentials(String username, String password) {
        // Check if the given username and password match with the stored credentials
        if (this.credentialMap.containsKey(username) &&
                this.credentialMap.get(username).equals(password)) {
            return true;
        }

        return false;
    }
}