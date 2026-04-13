public class java_39191_CredentialValidator_A08 {

    // Method to check if the password meets the requirements
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        // Check for minimum length
        if (password.length() < 8) {
            return false;
        }

        // Check for presence of at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for presence of at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
       
        // Check for presence of at least one digit
        } if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for presence of at least one special character
        if (!password.matches(".*[@$#&*].*")) {
            return false;
        }

        return true;
    }
}