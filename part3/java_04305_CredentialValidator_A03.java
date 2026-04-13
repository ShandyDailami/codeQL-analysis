import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class java_04305_CredentialValidator_A03 {
    private static final Pattern PASSWORD_PATTERN;

    static {
        // We use a very simple pattern for this example. It matches any string of characters that is at least 8 characters long,
        // contains one digit, one uppercase letter, one lowercase letter, and one special character.
        // This is a very basic pattern and you can adjust it to match your needs.
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        PASSWORD_PATTERN = Pattern.compile(passwordPattern);
    }

    public boolean isPasswordValid(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        System.out.println(validator.isPasswordValid("Password123")); // true
        System.out.println(validator.isPasswordValid("password123")); // false
    }
}