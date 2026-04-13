import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_37812_CredentialValidator_A01 {

    // Map to store credential data for testing
    private Map<String, String> credentialData = new HashMap<>();

    // Initialize the credential data
    public java_37812_CredentialValidator_A01() {
        credentialData.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialData.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    // Method to validate a credential
    public boolean validateCredential(String user, String password) {
        // If the user is in the data
        if (credentialData.containsKey(user)) {
            // Decode the password from base64
            byte[] decodedPassword = Base64.getDecoder().decode(credentialData.get(user));

            // Convert password to a string
            String decodedPasswordString = new String(decodedPassword);

            // Compare the passwords
            return password.equals(decodedPasswordString);
        }

        // If the user is not in the data
        return false;
    }
}