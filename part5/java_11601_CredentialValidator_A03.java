import java.util.Base64;
import java.util.Optional;

public class java_11601_CredentialValidator_A03 {
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public Optional<String> validate(String username, String password) {
        if (!username.equals(VALID_USERNAME) || !password.equals(VALID_PASSWORD)) {
            return Optional.of("Invalid username or password");
        }
        return Optional.empty();
    }

    public String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        Optional<String> result = validator.validate("invalidUser", validator.encryptPassword("invalidPassword"));

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Access granted");
        }
    }
}