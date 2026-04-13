import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_33204_CredentialValidator_A07 {
    // Constants
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    // Methods
    public boolean isPasswordValid(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isPasswordValid("Password@123")); // This should return true
        System.out.println(validator.isPasswordValid("password")); // This should return false
    }
}