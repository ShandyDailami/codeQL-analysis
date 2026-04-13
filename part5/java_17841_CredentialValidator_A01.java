public class java_17841_CredentialValidator_A01 {

    // Define some predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // This method validates the provided username and password
    public boolean validate(String providedUsername, String providedPassword) {
        // If the provided username and password match our predefined credentials, return true
        return providedUsername.equals(USERNAME) && providedPassword.equals(PASSWORD);
    }

    // Entry point for the program
    public static void main(String[] args) {
        // Create a new instance of the CredentialValidator
        SecureCredentialValidator validator = new SecureCredentialValidator();

        // Test the validator with some credentials
        System.out.println(validator.validate("admin", "password")); // Should print true
        System.out.println(validator.validate("user", "wrongpassword")); // Should print false
    }
}