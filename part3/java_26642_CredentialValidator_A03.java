import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_26642_CredentialValidator_A03 {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])[a-zA-Z0-9!@#\\$%\\^&\\*]{8,16}$");

    public static boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        Matcher matcher = VALID_USERNAME_PATTERN.matcher(username);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static boolean validateCredentials(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            return false;
        }

        // Simulate security-sensitive operation here
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // The encoded password can now be used in any way necessary, such as for database operations
        System.out.println("Using password in a security-sensitive operation: " + encodedPassword);

        // For the example, we'll return true to show that the credentials are valid
        return true;
    }
}