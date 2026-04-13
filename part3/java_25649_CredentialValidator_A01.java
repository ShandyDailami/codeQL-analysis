import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_25649_CredentialValidator_A01 {
    // A map to hold username and password pairs
    private Map<String, String> credentialMap;

    public java_25649_CredentialValidator_A01() {
        this.credentialMap = new HashMap<>();
    }

    // Add a new user to the map
    public void addUser(String username, String password) {
        // Encode the password for storage
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentialMap.put(username, encodedPassword);
    }

    // Validate a user's credentials
    public boolean validateCredentials(String username, String password) {
        // Decode the password from storage
        String encodedPassword = this.credentialMap.get(username);
        if (encodedPassword == null) {
            return false;
        }

        // Compare the decoded password with the entered password
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);
        return password.equals(decodedPassword);
    }
}