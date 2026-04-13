public class java_22672_CredentialValidator_A08 {
    // Constant for minimum password length
    private static final int MIN_PASSWORD_LENGTH = 8;

    // Method to validate password
    public boolean validatePassword(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password is too short
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains a number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if password contains a special character
        if (!password.matches(".*[!@#$%^&*(),.?\\-+].*")) {
            return false;
        }

        // If all checks pass, password is valid
        return true;
    }
}