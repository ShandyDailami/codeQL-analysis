public class java_07747_CredentialValidator_A08 {
    private static final Logger logger = Logger.getLogger(CredentialValidator.class);

    public boolean validateCredentials(String username, String password) {
        // Step 1: Check if the username is null or empty
        if (username == null || username.isEmpty()) {
            logger.error("Username is null or empty");
            return false;
        }

        // Step 2: Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            logger.error("Password is null or empty");
            return false;
        }

        // Step 3: Check if the password is strong enough
        if (!isPasswordStrong(password)) {
            logger.error("Password is not strong enough");
            return false;
        }

        // All checks passed, return true
        return true;
    }

    private boolean isPasswordStrong(String password) {
        // Assuming a password is strong if it's at least 8 characters long, and contains a number and a special character
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*().?\\-+].*");
    }
}