import java.util.Base64;
import java.util.Optional;

public class java_38297_CredentialValidator_A07 {

    private static final String AUTH_FAILURE_PREFIX = "AUTH_FAILURE";

    public Optional<String> validate(String userName, String password) {
        // Simulating security-sensitive operation related to authentication failure
        // This is a placeholder, in real use cases, this operation should involve more complex logic
        if (userName == null || password == null) {
            return Optional.of(AUTH_FAILURE_PREFIX + " Invalid username or password");
        }

        String plainPassword = new String(Base64.getDecoder().decode(password));
        if (plainPassword.equals("password")) {
            return Optional.of(AUTH_FAILURE_PREFIX + " Invalid password");
        }

        return Optional.empty();
    }
}