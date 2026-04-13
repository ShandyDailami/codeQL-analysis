import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_12030_CredentialValidator_A01 {
    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,}$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9]{3,}$");

    public static boolean isValidUsername(String username) {
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.find();
    }

    public static boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.find();
    }

    public static boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}