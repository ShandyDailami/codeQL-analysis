import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_37571_CredentialValidator_A07 {

    // Credentials are stored as base64 encoded strings
    private Map<String, String> credentials = new HashMap<>();

    // Add a new credential
    public void addCredential(String userId, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        credentials.put(userId, encodedPassword);
    }

    // Validate a user's credential
    public boolean validateCredential(String userId, String password) {
        String encodedPassword = credentials.get(userId);

        // If no credential exists for the user
        if (encodedPassword == null) {
            return false;
        }

        // Decode the password from base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);

        // Validate the password
        return password.equals(decodedPassword);
    }
}