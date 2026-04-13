import java.security.InvalidParameterException;

public class java_28756_CredentialValidator_A08 {
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%^*?&])[A-Za-z0-9@$!%^*?&]{8,}$";

    public boolean validate(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        if (!username.matches(USERNAME_REGEX)) {
            throw new InvalidParameterException("Invalid username. It should only contain alphanumeric characters and underscores.");
        }

        if (!password.matches(PASSWORD_REGEX)) {
            throw new InvalidParameterException("Invalid password. It should contain at least one lowercase letter, one uppercase letter, one digit, and one special character.");
        }

        // Validation passed, return true
        return true;
    }
}