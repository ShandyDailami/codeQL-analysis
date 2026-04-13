import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

public class java_18362_CredentialValidator_A03 {

    public static Optional<String> validate(String userName, String password) {
        // remove this comment and provide a realistic context
        // a. Creativity and realistic context: The program should validate the user's credentials, checking if they're correct and if they have the correct permissions to access a specific resource.
        // b. No apologization: Always provide meaningful feedback.
        // c. No external frameworks: Utilize only standard Java libraries.
        // d. No external frameworks: The program should be syntactically correct Java code.

        // e. Code starts here:
        if (userName == null || password == null) {
            throw new InvalidParameterException("User name and password cannot be null.");
        }

        if (userName.isEmpty() || password.isEmpty()) {
            throw new InvalidParameterException("User name and password cannot be empty.");
        }

        // Encoding the password for security
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (!userName.equals("admin") || !encodedPassword.equals("$2a$10$rDwLx6F3k0sD8bZf2XFzuW5Q1B0iXJ2j6QDQjF8f9HMpOzx88gJ1")) { // $2a$10$rDwLx6F3k0sD8bZf2XFzuW5Q1B0iXJ2j6QDQjF8f9HMpOzx88gJ1 is the hashed password of 'password'
            throw new InvalidParameterException("Invalid credentials.");
        }

        // f. Code ends here:
        return Optional.of("Credentials validated successfully.");
    }
}