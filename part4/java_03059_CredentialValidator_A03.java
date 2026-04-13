import java.security.InvalidParameterException;
import java.util.Base64;

public class java_03059_CredentialValidator_A03 {

    // A simple credential validator that validates if a username and password are valid.
    // This is not secure against injection, but it's a good start.
    public boolean isValidCredential(String username, String password) {
        // The username and password are expected to be base64 encoded.
        // If they are not, this will cause an InvalidParameterException.
        byte[] decodedBytes = Base64.getDecoder().decode(username);
        String decodedUsername = new String(decodedBytes);
        decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);

        // Check if the username and password are valid.
        // In a real-world application, you'd typically use a secure way of comparing passwords.
        // For this example, we'll just check if they are the exact same strings.
        if (decodedUsername.equals(username) && decodedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}