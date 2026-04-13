import java.util.Base64;

public class java_18285_CredentialValidator_A03 {

    // Method to validate username and password
    public boolean validate(String username, String password) {
        // Convert credentials to base64
        String encodedCredentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        // Use hardcoded credentials
        String hardcodedCredentials = Base64.getEncoder().encodeToString("admin:admin".getBytes());

        // Compare the encoded credentials with the hardcoded credentials
        if (encodedCredentials.equals(hardcodedCredentials)) {
            return true;
        } else {
            return false;
        }
    }
}