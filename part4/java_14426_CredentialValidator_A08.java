import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_14426_CredentialValidator_A08 {

    // Define the password requirements
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    // The validate method
    public static boolean validate(String password) {
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validate("YourPassword123@")); // Password is valid
        System.out.println(validate("password")); // Password is invalid
    }
}