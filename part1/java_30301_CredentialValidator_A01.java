public class java_30301_CredentialValidator_A01 {
    // Pre-defined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String inputUsername, String inputPassword) {
        // Check if the provided credentials match the pre-defined credentials
        if (inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD)) {
            return true; // Valid credentials
        } else {
            return false; // Invalid credentials
        }
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(validate("admin", "password")); // Expected output: true
        System.out.println(validate("invalid", "password")); // Expected output: false
    }
}