import java.security.InvalidParameterException;
import java.util.Arrays;

public class java_10152_CredentialValidator_A08 {
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]+$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*-])(?=\\S+$).{8,}$";

    public boolean isValidUsername(String username) {
        return username != null && username.matches(USERNAME_PATTERN);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.matches(PASSWORD_PATTERN);
    }

    public boolean areCredentialsValid(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        // In a real application, you'd actually authenticate against a database or other security system
        // Here, we're just checking the validity of the credentials, so just return true or false
        return true;
    }
}