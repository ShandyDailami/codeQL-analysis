import java.security.SecureRandom;
import java.util.regex.Pattern;

public class java_38104_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String ALL_NUMBERS = "0123456789";
    private static final String ALL_LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALL_UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Regular expression patterns
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])(?=\\S+$).{8,}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])(?=\\S+$).{8,}$");

    private SecureRandom random = new SecureRandom();

    public boolean validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Validate password strength
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException("Password does not meet complexity requirements (must contain at least one number, one upper case letter, one lower case letter, one special character, and be at least 8 characters long)");
        }

        // If validation passed, return true
        return true;
    }

    public boolean validateUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Validate username strength
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            throw new IllegalArgumentException("Username does not meet complexity requirements (must contain at least one number, one upper case letter, one lower case letter, one special character, and be at least 8 characters long)");
       
        // If validation passed, return true
        return true;
    }
}