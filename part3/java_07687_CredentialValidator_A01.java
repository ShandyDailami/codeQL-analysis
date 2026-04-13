public class java_07687_CredentialValidator_A01 {
    // Pre-defined set of credentials
    private static final String ALLOWED_USERNAME = "admin";
    private static final String ALLOWED_PASSWORD = "password";

    // Method to check if a username and password match the allowed set
    public static boolean validateCredentials(String username, String password) {
        return username.equals(ALLOWED_USERNAME) && password.equals(ALLOWED_PASSWORD);
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        boolean isValid = CredentialValidator.validateCredentials("admin", "password");
        if (isValid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}