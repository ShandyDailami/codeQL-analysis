import java.util.Base64;
import java.util.Optional;

public class java_11708_CredentialValidator_A08 {
    private CredentialRepository repository;

    public java_11708_CredentialValidator_A08(CredentialRepository repository) {
        this.repository = repository;
    }

    public Optional<String> validateCredentials(String username, String password) {
        // Step 1: Encoding the password
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Step 2: Validating the credentials
        if (repository.validateCredentials(username, encodedPassword)) {
            return Optional.of(username);
        } else {
            return Optional.empty();
        }
    }
}