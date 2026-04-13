import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_28525_CredentialValidator_A01 {

    // Regular expression for password validation (at least one uppercase, one lowercase, one special character, one digit, minimum length 8)
    private static final Pattern passwordValidator = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[A-Za-z0-9@#$%^&*]{8,}$");

    // Regular expression for username validation (minimum length 4)
    private static final Pattern usernameValidator = Pattern.compile("^.{4,}$");

    public boolean isValidPassword(String password) {
        Matcher matcher = passwordValidator.matcher(password);
        if(matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidUsername(String username) {
        Matcher matcher = usernameValidator.matcher(username);
        if(matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}