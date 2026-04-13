public class java_14556_CredentialValidator_A08 {

    // Predefined valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    // Method to validate a username and password
    public static boolean validate(String username, String password) {
        // Check if the provided username and password match the predefined ones
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            System.out.println("Credentials are valid.");
            return true;
        } else {
            System.out.println("Credentials are not valid.");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator with valid credentials
        validate("admin", "password");

        // Test the validator with invalid credentials
        validate("invalid", "invalid");
    }
}