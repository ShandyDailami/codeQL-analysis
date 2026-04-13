import java.util.Base64;
import java.util.Optional;

public class java_30916_CredentialValidator_A07 {

    public Optional<String> validate(String userName, String password) {
        // In a real-world scenario, you would usually have an authentication service
        // to verify the username and password against a database or another secure
        // authentication service. This example just simulates the process.

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if ("secure_user".equals(userName) && "secure_password".equals(encodedPassword)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();
        Optional<String> result = validator.validate("secure_user", "secure_password");

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Authentication successful");
        }
    }
}