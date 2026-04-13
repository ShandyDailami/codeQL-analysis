public class java_34136_CredentialValidator_A03 {

    // Hardcoded valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    // Method to validate credentials
    public static boolean validateCredentials(String username, String password) {
        // Matching username and password with hardcoded values
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Testing the validateCredentials method
        boolean result = validateCredentials("admin", "password");
        if (result) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}