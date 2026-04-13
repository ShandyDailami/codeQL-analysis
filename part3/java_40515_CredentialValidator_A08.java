public class java_40515_CredentialValidator_A08 {
    // Method to check if password is valid
    public boolean isValidPassword(String password) {
        // Check if password is not null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains a digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if password contains an uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // If all checks pass, password is valid
        return true;
    }
}