import java.util.Base64;
import java.util.Optional;

public class java_22037_CredentialValidator_A03 {
    // A very simple implementation of the CredentialValidator interface.

    public Optional<String> validateCredentials(String encodedCredentials) {
        try {
            // Decode the credentials.
            byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
            String decodedCredentials = new String(decodedBytes);

            // Split the decoded credentials into username and password.
            String[] credentials = decodedCredentials.split(":");

            // Validate the credentials (e.g., username and password length, correct format).
            if (credentials.length != 2 || credentials[0].length() == 0 || credentials[1].length() == 0) {
                return Optional.empty();
            }

            return Optional.of(credentials[0]);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}