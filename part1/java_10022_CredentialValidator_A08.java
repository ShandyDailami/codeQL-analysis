import java.util.Arrays;
import java.util.List;

public class java_10022_CredentialValidator_A08 {

    private static final List<String> STRONG_PASSWORDS = Arrays.asList("password", "strongPassword", "securePassword", "strongPassword123", "123Password", "123456");

    public static boolean isPasswordStrong(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (STRONG_PASSWORDS.contains(password)) {
            return true;
        }

        return hasDigit(password) && hasUpperCase(password) && hasLowerCase(password) && hasSpecialChar(password);
    }

    private static boolean hasDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private static boolean hasSpecialChar(String password) {
        return password.matches(".*[!@#$%^&*()_+\\-={}\\[\\]|<>?].*");
    }
}