import java.util.Objects;
import java.util.regex.Pattern;

public class java_26249_CredentialValidator_A01 {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_.+-]+$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");

    public boolean isValidUsername(String username) {
        return Objects.nonNull(username) && VALID_USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return Objects.nonNull(password) && VALID_PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}