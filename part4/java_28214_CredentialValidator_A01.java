import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28214_CredentialValidator_A01 {
    private static final String SAMPLE_USERNAME = "user";
    private static final String SAMPLE_PASSWORD = "password";

    public Map<String, String> validate(String username, String password) {
        Map<String, String> errors = new HashMap<>();

        if (!username.equals(SAMPLE_USERNAME) || !password.equals(SAMPLE_PASSWORD)) {
            errors.put("username", "Invalid username or password");
        }

        return errors;
    }

    public String getBase64EncodedPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        Map<String, String> errors = validator.validate("user", "password");

        if (!errors.isEmpty()) {
            System.out.println("Errors: " + errors);
        } else {
            System.out.println("Credentials are valid");
        }
    }
}