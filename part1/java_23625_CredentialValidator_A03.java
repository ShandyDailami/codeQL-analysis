import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_23625_CredentialValidator_A03 {

    public static boolean validateUsername(String username) {
        // Simple pattern to match usernames
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean validatePassword(String password) {
        // Simple pattern to match passwords
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validatePasswordStrength(String password) {
        // Simple pattern to match passwords
        // We're assuming a password is considered strong if it contains a number, uppercase letter, lowercase letter, and special character
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validateBase64(String base64) {
        // Simple pattern to match base64
        Pattern pattern = Pattern.compile("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}={1,2})*$");
        Matcher matcher = pattern.matcher(base64);
        return matcher.matches();
    }

    public static boolean validateUsernameAndPassword(String username, String password) {
        return validateUsername(username) && validatePassword(password);
    }

    public static boolean validateBase64AndPassword(String base64, String password) {
        return validateBase64(base64) && validatePassword(password);
    }

    public static void main(String[] args) {
        // Test the validation methods
        System.out.println(validateUsernameAndPassword("testUser", "testPassword"));
        System.out.println(validateBase64AndPassword("ZW5jb2RlZERleHQ=", "testPassword"));
    }
}