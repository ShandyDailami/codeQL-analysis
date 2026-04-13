public class java_02094_CredentialValidator_A08 {

    public boolean isPasswordStrong(String password) {
        // Check if password is too short
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if password contains a uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if password contains a number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // If all checks passed, the password is strong
        return true;
    }
}