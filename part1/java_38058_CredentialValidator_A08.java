public class java_38058_CredentialValidator_A08 {
    // Define a minimum password length
    private static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isPasswordStrongEnough(String password) {
        // Check if the password is null
        if (password == null) {
            return false;
        }

        // Check if the password is at least MIN_PASSWORD_LENGTH
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        // Check if the password contains at least one uppercase letter, one lowercase letter, and one digit
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // If all checks pass, the password is strong
        return true;
    }
}