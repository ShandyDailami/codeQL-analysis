public class java_23087_CredentialValidator_A08 {

    // Define a set of predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // CredentialValidator method
    public boolean validate(String inputUsername, String inputPassword) {
        // Check if the provided username and password match
        if (inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD)) {
            return true; // Credentials are valid
        } else {
            return false; // Credentials are invalid
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method
        System.out.println(validator.validate("admin", "password")); // Should print: true
        System.out.println(validator.validate("wrongUsername", "password")); // Should print: false
        System.out.println(validator.validate("admin", "wrongPassword")); // Should print: false
    }
}