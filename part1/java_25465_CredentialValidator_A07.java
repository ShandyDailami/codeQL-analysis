public class java_25465_CredentialValidator_A07 {

    public static boolean isValidPassword(String password) {
        // Check for minimum length of 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for at least one special character
        if (!password.matches(".*[~!@#$%^&*()_=+{}\\[\\]:\";'<,>.?\\/\\\\]+.*")) {
            return false;
        }

        // If all checks passed, the password is valid
        return true;
    }

    public static void main(String[] args) {
        // Test the password validator
        System.out.println(isValidPassword("Password@123")); // Should print true
        System.out.println(isValidPassword("password")); // Should print false
    }
}