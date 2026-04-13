public class java_08873_CredentialValidator_A01 {
    // Hard-coded set of credentials.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the credentials.
    public static boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validator.
        boolean isValid = CredentialValidator.validateCredentials("admin", "password");
        System.out.println("Is valid: " + isValid);
    }
}