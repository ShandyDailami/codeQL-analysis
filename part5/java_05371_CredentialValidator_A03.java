import java.util.Base64;
import java.util.Optional;

public class java_05371_CredentialValidator_A03 {
    public Optional<String> validate(String credential) {
        // Decode the credential into Base64
        byte[] decodedBytes = Base64.getDecoder().decode(credential);
        String decodedCredential = new String(decodedBytes);

        // Validate the credential (e.g., check for common passwords)
        if (isCommonPassword(decodedCredential)) {
            return Optional.empty(); // No error
        } else {
            return Optional.of("Common passwords are not allowed"); // Error
        }
    }

    // This method is left intentionally blank for this example
    private boolean isCommonPassword(String password) {
        // The list of common passwords is intentionally left blank
        // In a real application, you would replace this with a list of common passwords
        return false;
    }
}