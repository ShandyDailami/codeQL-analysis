public class java_30005_CredentialValidator_A08 {

    // Method to validate password
    public boolean validatePassword(String password) {
        // Check if the password is null
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        // Check if the password contains at least one digit
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one digit");
        }

        // Check if the password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }

        // Check if the password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }

        // If all checks pass, the password is valid
        return true;
    }
}