import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_10470_CredentialValidator_A03 {

    private static final Pattern VALID_USERNAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern VALID_PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d\\W]+$");

    public boolean isValidUsername(String username) {
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}