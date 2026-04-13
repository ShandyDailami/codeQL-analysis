import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_14855_CredentialValidator_A08 {

    private static final Pattern PASSWORD_PATTERN;
    private static final String PASSWORD_PATTERN_STR;

    static {
        // Define the pattern that a password must match.
        // This pattern will check if the password contains at least one lowercase letter, one uppercase letter, one number, and one special character.
        PASSWORD_PATTERN_STR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%^*?&])[A-Za-z0-9@$!%^*?&]{8,}$";
        PASSWORD_PATTERN = Pattern.compile(PASSWORD_PATTERN_STR);
    }

    public boolean validatePassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
}