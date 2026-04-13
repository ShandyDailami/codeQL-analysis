public class java_25598_CredentialValidator_A07 {
    // Hardcoded username and password
    private static final String HARDCODED_USERNAME = "test";
    private static final String HARDCODED_PASSWORD = "password";

    // Method to validate username and password
    public boolean validate(String username, String password) {
        // Check if provided username and password match hardcoded values
        if (username.equals(HARDCODED_USERNAME) && password.equals(HARDCODED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Instantiate the CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        boolean isValid = validator.validate("test", "password");

        // Print the result
        if (isValid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}