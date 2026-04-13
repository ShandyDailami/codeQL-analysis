import java.util.regex.Pattern;

public class java_06557_CredentialValidator_A08 {
    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("[A-Za-z0-9_]+");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("[A-Za-z0-9_@#$%^&*=]{8,}");

    public boolean isValidUsername(String username) {
        return VALID_USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return VALID_PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        if (!isValidUsername(username)) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        // Assume here that the credentials are valid
        return true;
    }
}