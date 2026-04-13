public class java_29042_CredentialValidator_A08 {
    // Hard-coded set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if the provided credentials match the hard-coded credentials
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a CredentialValidator instance
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method
        boolean result = validator.validate("admin", "password");

        if (result) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}