import java.util.regex.Pattern;

public class java_15298_CredentialValidator_A03 {

    // Check if password is secure
    public static boolean isValid(String password) {

        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password is too short
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains a letter
        if (!Pattern.matches(".*[a-z].*", password)) {
            return false;
        }

        // Check if password contains a number
        if (!Pattern.matches(".*[0-9].*", password)) {
            return false;
        }

        // Check if password contains a special character
        if (!Pattern.matches(".*[^a-zA-Z0-9].*", password)) {
            return false;
        }

        // Check if password is not the default password
        if (password.equals("password")) {
            return false;
        }

        // If all checks are passed, password is valid
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValid("password")); // Output: false
        System.out.println(isValid("12345678")); // Output: false
        System.out.println(isValid("abcdefg")); // Output: false
        System.out.println(isValid("abc1234")); // Output: false
        System.out.println(isValid("abc123!")); // Output: false
        System.out.println(isValid("123abc!")); // Output: true
    }
}