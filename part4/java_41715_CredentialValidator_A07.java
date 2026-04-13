public class java_41715_CredentialValidator_A07 {

    // Define a class-level variable for the password strength.
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private static final int MAXIMUM_PASSWORD_LENGTH = 16;

    // Define a method for checking if a password meets the strength requirements.
    public static boolean isValidPassword(String password) {
        // Check if password length is within the set range.
        if (password.length() < MINIMUM_PASSWORD_LENGTH || password.length() > MAXIMUM_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, and one digit.
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // If all checks pass, password is valid.
        return true;
    }
}