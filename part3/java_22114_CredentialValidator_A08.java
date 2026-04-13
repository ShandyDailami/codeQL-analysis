import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_22114_CredentialValidator_A08 {
    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        // Check password length
        if (password.length() < 8) {
            return false;
        }

        // Check for at least one upper case letter
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        // Check for at least one lower case letter
        pattern = Pattern.compile("[a-z]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
       
        // Check for at least one digit
        pattern = Pattern.compile("[0-9]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("Password123")); // Expected: true
        System.out.println(validatePassword("password")); // Expected: false
        System.out.println(validatePassword("PASSWORD")); // Expected: false
        System.out.println(validatePassword("12345678")); // Expected: false
    }
}