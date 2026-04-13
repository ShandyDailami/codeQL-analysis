public class java_21155_CredentialValidator_A01 {
    // Hard-coded expected username and password
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    // Default constructor
    public java_21155_CredentialValidator_A01() {
    }

    // Method to validate credentials
    public boolean validate(String username, String password) {
        // Compare the entered username and password with the expected values
        if (username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD)) {
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a new CredentialValidator object
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method with valid credentials
        validator.validate("admin", "password");

        // Test the validate method with invalid credentials
        validator.validate("invalid", "invalid");
    }
}