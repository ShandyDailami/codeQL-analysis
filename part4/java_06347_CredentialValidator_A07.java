public class java_06347_CredentialValidator_A07 {

    // Predefined set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the username and password match
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true; // Valid credential
        } else {
            return false; // Invalid credential
        }
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(validate("admin", "password")); // Should print: true
        System.out.println(validate("invalid", "password")); // Should print: false
    }
}