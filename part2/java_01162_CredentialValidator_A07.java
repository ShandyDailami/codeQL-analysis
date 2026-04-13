public class java_01162_CredentialValidator_A07 {
    // A method that validates the password
    public boolean validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password contains a number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if the password contains an uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if the password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if the password contains a special character
        if (!password.matches(".*[@#$%^&*()_+\-=\\\\[{\\]};?><,./|\\\\`~].*")) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}