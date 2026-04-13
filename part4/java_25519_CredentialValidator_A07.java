import java.util.Base64;
import java.util.Optional;

public class java_25519_CredentialValidator_A07 {

    // Using Optional to handle case when credential is null
    public Optional<String> validateCredential(String credential) {
        // decode the base64 encoded credential
        Optional<String> decodedCredential = decodeCredential(credential);
        // validate the credential
        Optional<String> errorMessage = validate(decodedCredential);
        return errorMessage;
    }

    private Optional<String> decodeCredential(String credential) {
        // decode the base64 encoded credential
        byte[] decodedBytes = Base64.getDecoder().decode(credential);
        String decodedCredential = new String(decodedBytes);
        return Optional.of(decodedCredential);
    }

    private Optional<String> validate(Optional<String> decodedCredential) {
        // This is a placeholder. Replace this with your actual validation logic
        if(decodedCredential.isPresent()) {
            return Optional.empty();
        } else {
            return Optional.of("Credential is null");
        }
    }

}