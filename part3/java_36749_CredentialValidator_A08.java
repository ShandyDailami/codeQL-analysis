public class java_36749_CredentialValidator_A08 {
    // Method to validate if a password is strong
    public static boolean isPasswordStrong(String password) {
        // Checking for minimum length
        if (password.length() < 8) {
            return false;
        }

        // Checking for digits
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Checking for lower case letters
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Checking for upper case letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Checking for special characters
        if (!password.matches(".*[@#$%^&*()_+\\-={}\\[\]|\\`~].*")) {
            return false;
        }

        return true;
    }
}