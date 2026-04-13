public class java_23739_CredentialValidator_A08 {

    // Method to validate the password
    public boolean validatePassword(String password) {

        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        // Check if password has minimum length
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        // Check if password has upper case letter
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one upper case letter");
        }

        // Check if password has lower case letter
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lower case letter");
        }

        // Check if password has digit
        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one digit");
        }

        // Check if password has special character
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }

        // If password meets all criteria, return true
        return true;
    }
}