public class java_21280_CredentialValidator_A07 {

    // Hardcoded user credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the user credentials
    public boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a CredentialValidator object
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method
        boolean isValid = validator.validate("admin", "password");

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}