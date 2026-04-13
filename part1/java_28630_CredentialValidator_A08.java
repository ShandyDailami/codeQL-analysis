public class java_28630_CredentialValidator_A08 {

    // Minimum length for a password
    private static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }
        // Check if the password is at least MIN_PASSWORD_LENGTH characters long
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }
        // Check if the password contains at least one upper case letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        // Check if the password contains at least one lower case letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        // Check if the password contains at least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        // Check if the password contains at least one special character
        if (!password.matches(".*[~!@#$%^&*()_=-].*")) {
            return false;
        }
        // If all checks passed, the password is valid
        return true;
    }
}