import java.util.Base64;
import java.util.Optional;

public class java_38825_CredentialValidator_A07 {
    // Attempt to decode the credential. If successful, return an Optional with the username.
    // If not, return an empty Optional.
    private Optional<String> decodeCredential(String credential) {
        try {
            // Decode the credential
            String decoded = new String(Base64.getDecoder().decode(credential), "UTF-8");
            // Get the username from the decoded string
            String username = decoded.substring(0, decoded.indexOf(':'));
            return Optional.of(username);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Attempt to validate the credential. If successful, return true.
    // If not, return false.
    public boolean validateCredential(String credential) {
        return decodeCredential(credential).isPresent();
    }
}