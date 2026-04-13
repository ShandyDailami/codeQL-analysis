public class java_20245_CredentialValidator_A01 {
    // Hardcoded credentials.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Main method to validate credentials.
    public static boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validator with valid credentials.
        boolean isValid = CredentialValidator.validate("admin", "password");
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}