public class java_08743_CredentialValidator_A07 {

    // Define hard-coded credentials
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        if (validator.validateCredentials("test", "test")) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}