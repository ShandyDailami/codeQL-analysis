import java.util.Base64;

public class java_06163_CredentialValidator_A03 {
    public boolean validateCredentials(String username, String password) {
        // This is a placeholder for a real-world application.
        // In a real-world application, passwords should never be stored in plain text.
        // A real-world application would hash the password and compare the hash.

        String expectedUsername = "admin";
        String expectedPassword = "password";

        // Decode the base64 encoded passwords for comparison
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordString = new String(decodedPassword);

        if (username.equals(expectedUsername) && decodedPasswordString.equals(expectedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}