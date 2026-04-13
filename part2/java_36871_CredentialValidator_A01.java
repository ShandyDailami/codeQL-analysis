import java.util.Base64;
import java.util.Optional;

public class java_36871_CredentialValidator_A01 {
    public Optional<String> validateCredentials(String username, String password) {
        // We'll simulate the actual access control by decoding the credentials
        Optional<String> decodedPassword = decodePassword(password);
        if (decodedPassword.isPresent()) {
            return Optional.of("Successfully logged in as: " + username);
        } else {
            return Optional.empty();
        }
    }

    private Optional<String> decodePassword(String password) {
        // We'll use a basic Base64 decoding here, for real-world scenarios you might use a more secure method
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        return Optional.of(new String(decodedBytes));
    }
}