import java.util.Objects;
import java.util.Base64;

public class java_08630_CredentialValidator_A08 implements CredentialValidator {

    // This is a hardcoded username and password
    private final String hardcodedUsername = "admin";
    private final String hardcodedPassword = Base64.getEncoder().encodeToString("password".getBytes());

    @Override
    public Optional<String> validateCredentials(String username, String password) {
        // We decode the password for comparison
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // Check if the provided credentials match the hardcoded ones
        if (Objects.equals(username, hardcodedUsername) && Objects.equals(decodedPassword, hardcodedPassword)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }
}