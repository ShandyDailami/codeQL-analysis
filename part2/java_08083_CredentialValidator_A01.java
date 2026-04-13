import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_08083_CredentialValidator_A01 implements CredentialValidator {
    // Regex pattern for username
    private static final Pattern VALID_USERNAME = Pattern.compile("^[A-Za-z0-9+/]{4}*[A-Za-z0-9+/]{1,}=[A-Za-z0-9+/]{1,}$");

    // Regex pattern for password
    private static final Pattern VALID_PASSWORD = Pattern.compile("^[A-Za-z0-9+/]{3,}$");

    @Override
    public boolean validate(String username, String password) {
        if (isValidUsername(username) && isValidPassword(password)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidUsername(String username) {
        Matcher matcher = VALID_USERNAME.matcher(username);
        return matcher.find();
    }

    private boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD.matcher(password);
        return matcher.find();
    }
}