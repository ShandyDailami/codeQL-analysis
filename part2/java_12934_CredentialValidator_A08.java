public class java_12934_CredentialValidator_A08 {
    // A simple method to check if a password meets certain criteria
    public boolean validatePassword(String password) {
        // Check if the password is null or is shorter than 8 characters
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check if the password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if the password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // If the password passes all checks, it is valid
        return true;
    }
}