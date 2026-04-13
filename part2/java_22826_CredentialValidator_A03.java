import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_22826_CredentialValidator_A03 {
    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,}$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.find();
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.find();
    }
}