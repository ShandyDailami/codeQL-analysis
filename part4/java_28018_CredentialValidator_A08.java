public class java_28018_CredentialValidator_A08 {
    // Set of characters to check against
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    // Minimum length requirement for a password
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    // Method to check if a password meets the criteria
    public boolean isPasswordValid(String password) {
        // Check if password length is long enough
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains any of the allowed characters
        for (char c : password.toCharArray()) {
            if (!ALLOWED_CHARACTERS.contains(c + "")) {
                return false;
            }
        }

        // If we've made it this far, the password is valid
        return true;
    }
}