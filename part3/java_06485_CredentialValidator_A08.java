public class java_06485_CredentialValidator_A08 {

    // Define hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the given credentials match the hardcoded ones
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true; // Credentials are valid
        } else {
            return false; // Credentials are invalid
        }
    }

    public static void main(String[] args) {
        // Test the validator
        boolean isValid = CredentialValidator.validate("admin", "password");
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}