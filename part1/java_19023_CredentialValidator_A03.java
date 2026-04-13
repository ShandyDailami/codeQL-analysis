import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_19023_CredentialValidator_A03 {

    // Regular expression for a strong password
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public static boolean validatePassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Testing the validatePassword method
        System.out.println(validatePassword("ThisIsAPassword123!")); // true
        System.out.println(validatePassword("password")); // false
    }
}