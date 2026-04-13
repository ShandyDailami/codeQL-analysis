import java.security.InvalidParameterException;

public class java_24008_CredentialValidator_A07 {
    private static final String USERNAME_REGEX = "^[A-Za-z0-9_]+$";
    private static final String PASSWORD_REGEX = "^[A-Za-z0-9_*&@#]+$";

    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME_REGEX);
    }

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static boolean validateCredentials(String username, String password) throws InvalidParameterException {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        if (!isValidUsername(username)) {
            throw new InvalidParameterException("Invalid username.");
        }

        if (!isValidPassword(password)) {
            throw new InvalidParameterException("Invalid password.");
        }

        // If everything is valid, return true
        return true;
    }
}