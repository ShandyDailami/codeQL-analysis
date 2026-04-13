public class java_30361_CredentialValidator_A08 {
    public boolean isValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        
        // Check length
        if (password.length() < 8) {
            return false;
        }

        // Check for digits
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for lowercase letters
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for special characters
        if (!password.matches(".*[~`!@#$%^&*()_=-]{1}.*")) {
            return false;
        }

        return true;
    }
}