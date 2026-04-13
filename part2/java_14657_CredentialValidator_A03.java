import java.util.Base64;

public class java_14657_CredentialValidator_A03 {
    // Define a method for validating the credential
    public boolean validateCredential(String username, String password) {
        // In a real scenario, the credentials would be stored in a database, not in plain text.
        // This is for example purposes.
        String expectedUsername = "admin";
        String expectedPassword = "password";

        // Encode the expected password.
        String encodedPassword = Base64.getEncoder().encodeToString(expectedPassword.getBytes());

        // Validate the credentials.
        if (username.equals(expectedUsername) && password.equals(encodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}