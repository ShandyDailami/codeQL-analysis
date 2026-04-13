import java.util.Base64;
import java.util.Optional;

public class java_35319_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "validUsername";
    private static final String VALID_PASSWORD = "validPassword";

    public Optional<String> validate(String username, String password) {
        if (username == null || password == null) {
            return Optional.empty();
        }

        if (!username.equals(VALID_USERNAME) || !password.equals(VALID_PASSWORD)) {
            return Optional.of("Invalid username or password");
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String username = "validUsername";
        String password = "validPassword";

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        Optional<String> validationResult = validator.validate(username, encodedPassword);

        if (validationResult.isPresent()) {
            System.out.println("Validation failed: " + validationResult.get());
        } else {
            System.out.println("Validation successful");
        }
    }
}