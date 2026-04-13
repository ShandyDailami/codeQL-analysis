import java.security.InvalidParameterException;

public class java_26852_CredentialValidator_A07 {
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public boolean validateUsername(String username) {
        if (username == null || username.matches(".*\\s.*")) {
            throw new InvalidParameterException("Username must not be null and must not contain any space");
        }
        return username.matches(USERNAME_REGEX);
    }

    public boolean validatePassword(String password) {
        if (password == null || password.matches(".*\\s.*")) {
            throw new InvalidParameterException("Password must not be null and must not contain any space");
        }
        return password.matches(PASSWORD_REGEX);
    }

    public boolean validateCredentials(String username, String password) {
        if (!validateUsername(username) || !validatePassword(password)) {
            throw new InvalidParameterException("Username or password is not valid");
        }
        return true;
    }
}