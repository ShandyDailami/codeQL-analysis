import java.util.Base64;
import java.util.Optional;

public class java_22791_CredentialValidator_A07 {

    // The real-world credential validator would use a more complex mechanism, possibly involving hashing and salting,
    // database lookups, and more.
    // But for this example, let's just assume the user is a valid user and their password is correct.

    public Optional<String> validateCredentials(String user, String password) {
        if ("validUser".equals(user) && "validPassword".equals(password)) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        Optional<String> errorMessage = validator.validateCredentials("validUser", "validPassword");
        if (errorMessage.isPresent()) {
            System.out.println("Error: " + errorMessage.get());
        } else {
            System.out.println("Login successful!");
        }
    }
}