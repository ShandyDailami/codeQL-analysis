import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

public class java_08793_CredentialValidator_A07 {

    public Optional<String> validate(String user, String password) {
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Assume that the password has been hashed and stored
        // This is a simplified example, in a real-world scenario, you would actually compare the hashed password with the stored one
        if (!encodedPassword.equals("hashedPassword")) {
            return Optional.empty();
        } else {
            return Optional.of(user);
        }
    }
}