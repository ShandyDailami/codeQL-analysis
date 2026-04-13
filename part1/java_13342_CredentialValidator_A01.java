public class java_13342_CredentialValidator_A01 {

    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the provided username and password match the predefined credentials
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Authentication successful!");
            return true; // Authentication successful
        } else {
            System.out.println("Authentication failed!");
            return false; // Authentication failed
        }
    }

    public static void main(String[] args) {
        // Test the validation
        CredentialValidator.validate("admin", "password"); // Should print "Authentication successful!"
        CredentialValidator.validate("wrongUsername", "password"); // Should print "Authentication failed!"
        CredentialValidator.validate("admin", "wrongPassword"); // Should print "Authentication failed!"
    }
}