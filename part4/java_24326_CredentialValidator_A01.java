import java.util.regex.Pattern;

public class java_24326_CredentialValidator_A01 {

    // Required password length
    private static final int PASSWORD_LENGTH = 8;

    // Required pattern for password (at least one uppercase, one lowercase, one number and one special character)
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$");

    // Required pattern for username (no special characters, no spaces)
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9]+$");

    public boolean isValidPassword(String password) {
        return isValidLength(password) && isValidPattern(password, PASSWORD_PATTERN);
    }

    public boolean isValidUsername(String username) {
        return isValidLength(username) && isValidPattern(username, USERNAME_PATTERN);
    }

    private boolean isValidLength(String str) {
        return str.length() >= PASSWORD_LENGTH;
    }

    private boolean isValidPattern(String str, Pattern pattern) {
        return pattern.matcher(str).matches();
    }
}