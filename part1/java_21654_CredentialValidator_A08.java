import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_21654_CredentialValidator_A08 {

    public static boolean validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password is longer than 6 characters
        if (password.length() <= 6) {
            return false;
        }

        // Check if the password contains a digit
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("password")); // Should print false
        System.out.println(validatePassword("passw")); // Should print false
        System.out.println(validatePassword("password1")); // Should print true
    }
}