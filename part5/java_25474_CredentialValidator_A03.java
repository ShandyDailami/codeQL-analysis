import java.util.regex.Pattern;

public class java_25474_CredentialValidator_A03 {
    // Check if a password meets the requirements
    public static boolean isValidPassword(String password) {
        // Check for required length
        if (password.length() < 8) {
            return false;
        }

        // Check for required characters
        boolean hasDigit = Pattern.matches(".*\\d.*", password);
        boolean hasUpperCase = Pattern.matches(".*[A-Z].*", password);
        boolean hasSpecialChar = Pattern.matches(".*[^a-zA-Z0-9].*", password);

        // If all conditions are met, return true
        return hasDigit && hasUpperCase && hasSpecialChar;
    }

    public static void main(String[] args) {
        // Test with valid password
        System.out.println(isValidPassword("Password123!")); // Should print true

        // Test with password that doesn't meet the requirements
        System.out.println(isValidPassword("password")); // Should print false
    }
}