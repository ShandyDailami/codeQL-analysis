public class java_25811_CredentialValidator_A08 {
    public static boolean validate(String password) {
        // Check if password is null or empty
        if (password == null || password.length() == 0) {
            return false;
        }

        // Check if password meets length requirement
        if (password.length() < 8) {
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

        // Check if password contains at least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check if password contains at least one special character
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        }

        // If all checks pass, password is valid
        return true;
    }
}