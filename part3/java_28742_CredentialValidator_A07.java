import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28742_CredentialValidator_A07 {
    // A map to store credential information.
    private Map<String, String> credentialInfo = new HashMap<>();

    // Constructor to create the CredentialValidator object.
    public java_28742_CredentialValidator_A07(Map<String, String> credentialInfo) {
        this.credentialInfo = credentialInfo;
    }

    // Method to validate user credentials.
    public boolean validateCredentials(String username, String password) {
        // Decoding the base64-encoded password.
        byte[] decodedPassword = Base64.getDecoder().decode(credentialInfo.get(username));
        String decodedPasswordStr = new String(decodedPassword);

        // Checking if the decoded password matches the provided password.
        return decodedPasswordStr.equals(password);
    }
}