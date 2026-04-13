import java.security.InvalidParameterException;

public class java_13598_CredentialValidator_A07 {

    public boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidParameterException("Username is required");
        }
        // Check if username is unique
        // This is a simple example. In a real application, you would need to connect to a database and check if the username exists.
        return true;
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password is required");
        }
        // Check if password is strong enough
        // This is a simple example. In a real application, you would need to check if the password meets certain criteria (e.g. length, presence of special characters, etc.).
        return true;
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidParameterException("Email is required");
        }
        // Check if email is valid
        // This is a simple example. In a real application, you would need to use a regular expression or some other form of validation to ensure the email is in a valid format.
        return true;
    }
}