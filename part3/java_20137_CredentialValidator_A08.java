import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Optional;

public class java_20137_CredentialValidator_A08 {

    private static final String USER_PATTERN = "^[a-zA-Z0-9_.+-]+$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d.-]{8,}$";

    public Optional<String> validateUsername(String username) {
        if (username == null || username.matches(".*\\d.*")) {
            return Optional.of("Username should not contain numbers and should not be null.");
        }
        if (!username.matches(USER_PATTERN)) {
            return Optional.of("Username contains invalid characters.");
        }
        return Optional.empty();
    }

    public Optional<String> validatePassword(String password) {
        if (password == null || !password.matches(PASSWORD_PATTERN)) {
            return Optional.of("Password should be at least 8 characters, and contain uppercase and lowercase letters and digits.");
        }
        return Optional.empty();
    }

    public Optional<String> validateCredentials(String username, String password) {
        Optional<String> error = validateUsername(username);
        if (error.isPresent()) {
            return error;
        }
        error = validatePassword(password);
        if (error.isPresent()) {
            return error;
        }
        return Optional.empty();
    }
}