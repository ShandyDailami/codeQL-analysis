import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_40426_CredentialValidator_A07 {

    private static final Pattern VALID_USERNAME_PATTERN;

    static {
        String usernamePattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        VALID_USERNAME_PATTERN = Pattern.compile(usernamePattern);
    }

    public boolean isValidUsername(String username) {
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String invalidUsername = "invalid.username";
        String validUsername = "valid.username@example.com";

        System.out.println("Is " + invalidUsername + " a valid username? " + validator.isValidUsername(invalidUsername));
        System.out.println("Is " + validUsername + " a valid username? " + validator.isValidUsername(validUsername));
    }
}