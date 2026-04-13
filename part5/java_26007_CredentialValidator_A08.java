public class java_26007_CredentialValidator_A08 {

    // Minimum length for a password
    private static final int MIN_PASSWORD_LENGTH = 8;

    // Maximum length for a password
    private static final int MAX_PASSWORD_LENGTH = 16;

    // Minimum number of characters in a password
    private static final int MIN_PASSWORD_CHARS = 1;

    // Maximum number of characters in a password
    private static final int MAX_PASSWORD_CHARS = 32;

    // Check if a password is strong enough
    public static boolean isStrongEnough(String password) {
        if (password == null) {
            return false;
        }

        // Check if password is in the required length range
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains at least one number
        if (!hasNumber(password)) {
            return false;
        }

        // Check if password contains at least one lower case letter
        if (!hasLowerCaseLetter(password)) {
            return false;
        }

        // Check if password contains at least one upper case letter
        if (!hasUpperCaseLetter(password)) {
            return false;
        }

        // Check if password contains at least one special character
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // If all checks are passed, password is strong
        return true;
    }

    // Check if a password contains at least one number
    private static boolean hasNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    // Check if a password contains at least one lower case letter
    private static boolean hasLowerCaseLetter(String password) {
        return password.matches(".*[a-z].*");
    }

    // Check if a password contains at least one upper case letter
    private static boolean hasUpperCaseLetter(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Check if a password contains at least one special character
    private static boolean hasSpecialCharacter(String password) {
        return password.matches(".*[~!@#$%^&*()_=+{}\\[\\]|\\\"\\\\:;<,>].*");
    }
}