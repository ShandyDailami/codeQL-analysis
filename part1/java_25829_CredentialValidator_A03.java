import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.function.Predicate;

public class java_25829_CredentialValidator_A03 {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{8,}$");

    public boolean validate(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }

    private boolean isValidUsername(String username) {
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    private boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("validUser", "validPassword");
        System.out.println("Is Valid: " + isValid);
    }
}