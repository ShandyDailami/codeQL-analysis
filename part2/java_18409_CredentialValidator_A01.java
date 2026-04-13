public class java_18409_CredentialValidator_A01 {

    // Username and password to validate
    private static final String VALID_USERNAME = "valid_user";
    private static final String VALID_PASSWORD = "valid_password";

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Check if the provided username and password match our expected values
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }

    // Main method to test the class
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        if (validator.validate("valid_user", "valid_password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        // Test with invalid credentials
        if (validator.validate("invalid_user", "invalid_password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}