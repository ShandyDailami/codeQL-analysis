import java.security.InvalidParameterException;

public class java_06515_CredentialValidator_A03 {
    public static final String USERNAME_REGEX = "[a-zA-Z0-9_]+";
    public static final String PASSWORD_REGEX = "[a-zA-Z0-9_]{8,}";

    public boolean isValidUsername(String username) {
        return username != null && username.matches(USERNAME_REGEX);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    public boolean isValidCredentials(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        // Here you can perform more security-sensitive operations
        // for example, check against a database or a third-party service

        return true;
    }
}