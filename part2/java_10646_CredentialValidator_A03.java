public class java_10646_CredentialValidator_A03 {

    public boolean validate(String password) {
        // Check for null password
        if (password == null) {
            return false;
        }

        // Check for empty password
        if (password.trim().isEmpty()) {
            return false;
        }

        // Check for password length (minimum 8 characters)
        if (password.length() < 8) {
            return false;
        }

        // Check for password containing only numbers
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check for password containing only lowercase and uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for password containing only special characters
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        // If all checks passed, password is valid
        return true;
    }

}