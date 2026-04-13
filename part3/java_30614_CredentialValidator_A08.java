public class java_30614_CredentialValidator_A08 {

    // Method to validate the password
    public boolean validate(String password) {
        // Check if the password is not null
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains a digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if the password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if the password contains an uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }
}