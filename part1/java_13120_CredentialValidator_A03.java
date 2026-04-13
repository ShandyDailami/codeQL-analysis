public class java_13120_CredentialValidator_A03 {

    // Private constant to store the minimum password strength
    private static final int MIN_PASSWORD_LENGTH = 8;

    public boolean isValidPassword(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password is too short
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains a digit
        if (!hasDigit(password)) {
            return false;
        }

        // Check if password contains a special character
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // If all checks pass, the password is valid
        return true;
    }

    private boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }
}