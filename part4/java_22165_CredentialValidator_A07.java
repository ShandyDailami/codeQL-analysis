public class java_22165_CredentialValidator_A07 {
    // Define expected username and password
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the username and password match the expected values
        if (username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        // Test the validateCredentials method
        boolean isValid = validator.validateCredentials("admin", "password");
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}