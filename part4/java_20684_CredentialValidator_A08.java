public class java_20684_CredentialValidator_A08 {

    // Hard-coded set of credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if provided credentials match hard-coded values
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validate method
        boolean result = validate("admin", "password");
        System.out.println("Credentials are valid: " + result);
    }
}