import java.util.Base64;
import java.util.Optional;

public class java_19373_CredentialValidator_A03 {

    public Optional<String> validate(String username, String password) {
        if (username == null || username.isEmpty()) {
            return Optional.of("Username is required");
        }

        if (password == null || password.isEmpty()) {
            return Optional.of("Password is required");
        }

        String encodedCredentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        return Optional.empty();
    }
}