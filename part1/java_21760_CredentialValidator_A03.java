import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_21760_CredentialValidator_A03 {

    private static final Pattern VALID_USERNAME_PATTERN;
    private static final Pattern VALID_PASSWORD_PATTERN;

    static {
        // Define the regular expression for a valid username
        String usernamePattern = "^[a-zA-Z0-9]+$";

        // Define the regular expression for a valid password
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$";

        // Compile the regular expressions into Pattern objects
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

    public boolean validate(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        // TODO: Add real security logic here

        return true; // Return false if the credentials are invalid
    }
}