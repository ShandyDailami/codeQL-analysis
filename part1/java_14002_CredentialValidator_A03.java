public class java_14002_CredentialValidator_A03 {

    // Method to validate password
    public boolean validatePassword(String password) {

        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password length is less than 8
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // If all checks pass, password is valid
        return true;
    }
}