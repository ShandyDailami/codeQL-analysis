import java.util.Base64;
import java.util.Optional;

public class java_39374_CredentialValidator_A01 {

    // This is a simple mock for a real-world credential service
    private CredentialService credentialService;

    public java_39374_CredentialValidator_A01(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    public Optional<String> validateCredential(String userName, String password) {
        // Here we assume the CredentialService is not able to return null values
        if (credentialService.validateUser(userName, password)) {
            return Optional.of(userName);
        } else {
            return Optional.empty();
        }
    }

    public Optional<String> authenticateUser(String userName, String password) {
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // We are assuming here that the password is in the Base64 format
        if (credentialService.authenticateUser(userName, decodedPassword)) {
            return Optional.of(userName);
        } else {
            return Optional.empty();
        }
    }

    // Implement CredentialService with methods for testing
    // public boolean validateUser(String userName, String password) { ... }
    // public boolean authenticateUser(String userName, byte[] password) { ... }
}