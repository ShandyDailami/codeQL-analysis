import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_27681_CredentialValidator_A07 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$");

    public boolean validateUsername(String username) {
        Matcher matcher = USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public boolean validateCredentials(String username, String password) {
        if (!validateUsername(username)) {
            System.out.println("Invalid username. Must be alphanumeric and can include underscores.");
            return false;
        }
        if (!validatePassword(password)) {
            System.out.println("Invalid password. Must be at least 8 characters long and contain upper case, lower case, number and special character.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validator
        System.out.println(validator.validateCredentials("user", "password")); // Should print true and return true
        System.out.println(validator.validateCredentials("user", "weakpassword")); // Should print false and return false
        System.out.println(validator.validateCredentials("user123", "password")); // Should print false and return false
        System.out.println(validator.validateCredentials("user123", "Weak@password")); // Should print false and return false
    }
}