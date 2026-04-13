import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_26292_CredentialValidator_A07 {

    private static final Pattern VALID_USERNAME_PATTERN;
    private static final Pattern VALID_PASSWORD_PATTERN;

    static {
        String usernamePattern = "^[a-zA-Z0-9_]+$";
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        VALID_USERNAME_PATTERN = Pattern.compile(usernamePattern);
        VALID_PASSWORD_PATTERN = Pattern.compile(passwordPattern);
    }

    public boolean isValidUsername(String username) {
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
}