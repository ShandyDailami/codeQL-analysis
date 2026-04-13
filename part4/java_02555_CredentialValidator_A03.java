import java.util.Base64;
import java.util.Optional;

public class java_02555_CredentialValidator_A03 {

    public static Optional<String> validate(String credential) {
        Optional<String> optional = Optional.empty();

        // Decoding the credential from base64
        Optional<String> decodedCredential = decodeCredential(credential);

        // Validating the decoded credential (e.g., checking length, presence of non-alphanumeric characters)
        if (decodedCredential.isPresent()) {
            optional = validateCredential(decodedCredential.get());
        }

        return optional;
    }

    private static Optional<String> decodeCredential(String credential) {
        Optional<String> optional = Optional.empty();

        if (credential != null && !credential.isEmpty()) {
            byte[] decodedBytes = Base64.getDecoder().decode(credential);
            optional = Optional.of(new String(decodedBytes));
        }

        return optional;
    }

    private static Optional<String> validateCredential(String credential) {
        Optional<String> optional = Optional.empty();

        // Replace this with your actual validation logic
        if (credential.length() > 10) {
            optional = Optional.of(credential);
        }

        return optional;
    }
}