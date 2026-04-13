import java.util.Base64;
import java.util.Optional;

public class java_35169_CredentialValidator_A03 {

    public Optional<String> validateUserCredentials(String userId, String password) {
        // Here you should perform actual validation logic to check if the provided userId and password match with those stored in the database
        // For simplicity, let's assume the password is always 'password'

        // Validate the user Id
        if (!isValidUserId(userId)) {
            return Optional.empty();
        }

        // Validate the password
        if (!isValidPassword(password)) {
            return Optional.empty();
        }

        // If all validations passed, return a validated user id
        return Optional.of(userId);
    }

    // Assume the password is always 'password'
    private boolean isValidPassword(String password) {
        return password.equals("password");
    }

    // Assume the userId is always a string starting with 'admin'
    private boolean isValidUserId(String userId) {
        return userId.startsWith("admin");
    }
}