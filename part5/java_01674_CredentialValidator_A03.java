import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_01674_CredentialValidator_A03 {

    private static final Pattern PASSWORD_PATTERN;

    static {
        // Create a Pattern object for password validation
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        PASSWORD_PATTERN = Pattern.compile(passwordPattern);
    }

    public static boolean validatePassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String password = "password";
        if (validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}