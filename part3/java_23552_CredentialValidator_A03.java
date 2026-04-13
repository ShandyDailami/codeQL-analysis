import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_23552_CredentialValidator_A03 {
    // Regular expression for username and password validation
    private static final Pattern VALID_USERNAME = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern VALID_PASSWORD = Pattern.compile("^.{8,}$");

    // Method to validate username
    public boolean isValidUsername(String username) {
        Matcher matcher = VALID_USERNAME.matcher(username);
        return matcher.matches();
    }

    // Method to validate password
    public boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD.matcher(password);
        return matcher.matches();
    }

    // Main method to test the validation
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isValidUsername("valid_username")); // True
        System.out.println(validator.isValidPassword("valid_password")); // True
        System.out.println(validator.isValidUsername("invalid_username")); // False
        System.out.println(validator.isValidPassword("invalid_password")); // False
    }
}