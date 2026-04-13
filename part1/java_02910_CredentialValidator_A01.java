public class java_02910_CredentialValidator_A01 {

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one upper case letter
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check if password contains at least one lower case letter
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check if password contains at least one number
        if (!hasDigit(password)) {
            return false;
        }

        // Check if password contains at least one special character
        if (!hasSpecialChar(password)) {
            return false;
        }

        // If all checks passed, password is strong
        return true;
    }

    private static boolean hasUpperCase(String password) {
        // Use a regular expression to check if password contains at least one upper case letter
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        // Use a regular expression to check if password contains at least one lower case letter
        return password.matches(".*[a-z].*");
    }

    private static boolean hasDigit(String password) {
        // Use a regular expression to check if password contains at least one digit
        return password.matches(".*\\d.*");
    }

    private static boolean hasSpecialChar(String password) {
        // Use a regular expression to check if password contains at least one special character
        return password.matches(".*[!@#$%^&*(),.?\\-{}|_+`~\\\\].*");
    }

    public static void main(String[] args) {
        // Test the method
        System.out.println(isPasswordStrong("StrongPassword@123")); // Returns true
        System.out.println(isPasswordStrong("strongpassword123")); // Returns false
        System.out.println(isPasswordStrong("Password@123")); // Returns false
    }
}