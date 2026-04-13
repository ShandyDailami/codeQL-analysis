public class java_18947_CredentialValidator_A08 {

    // This is a simple check for the password to see if it contains at least 8 characters,
    // contains a digit, a lowercase letter, an uppercase letter, and a special character
    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        // Check for minimum password length
        if (password.length() < 8) {
            return false;
        }

        // Check for digits
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for lowercase letters
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for special characters
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\{\\}\\|:;\"'<,>.?\\\\\\/\\\\\\.]+.*")) {
            return false;
        }

        return true;
    }
}