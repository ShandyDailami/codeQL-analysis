public class java_15445_CredentialValidator_A07 {
    // Hardcoded password. In a real application, it should be stored in a secure way
    private static final String HARDCODED_PASSWORD = "password";

    // Method to validate a password
    public static boolean validateCredentials(String password) {
        // Check if the provided password matches the hardcoded password
        if (password.equals(HARDCODED_PASSWORD)) {
            System.out.println("Authentication Successful!");
            return true; // Authentication successful
        } else {
            System.out.println("Authentication Failed!");
            return false; // Authentication failed
        }
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        validateCredentials("password");
    }
}