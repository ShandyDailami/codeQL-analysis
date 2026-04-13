import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_07807_CredentialValidator_A07 {

    // Define a regex pattern for a strong password
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean validatePassword(String password) {
        // Match the password to the pattern
        Matcher matcher = passwordPattern.matcher(password);

        // If the password matches the pattern, it's strong
        return matcher.matches();
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        String strongPassword = "YourStrongPassword@123";
        String weakPassword = "weakpassword";

        if (validator.validatePassword(strongPassword)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
        }

        if (validator.validatePassword(weakPassword)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
        }
    }
}