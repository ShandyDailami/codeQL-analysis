public class java_21632_CredentialValidator_A07 {

    // Define the hardcoded set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // The method to validate the username and password
    public boolean validate(String username, String password) {
        // Check if the provided username and password match the hardcoded set
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        if (validator.validate("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        // Test invalid credentials
        if (validator.validate("invalid", "invalid")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}