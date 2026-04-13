public class java_08455_CredentialValidator_A08 {
    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the credential
    public static boolean validateCredentials(String username, String password) {
        // Check if the provided username matches the predefined one
        if (username.equals(USERNAME)) {
            // Check if the provided password matches the predefined one
            if (password.equals(PASSWORD)) {
                return true;
            } else {
                // If the provided password is incorrect, return false
                return false;
            }
        } else {
            // If the provided username is incorrect, return false
            return false;
        }
    }

    // Main method to test the validation
    public static void main(String[] args) {
        // Test the validation
        System.out.println(validateCredentials("admin", "password")); // Should print true
        System.out.println(validateCredentials("user", "wrongpassword")); // Should print false
        System.out.println(validateCredentials("nonexistentuser", "nonexistentpassword")); // Should print false
    }
}