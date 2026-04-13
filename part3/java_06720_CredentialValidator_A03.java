public class java_06720_CredentialValidator_A03 {
    // Define known credentials
    private static final String KNOWN_USERNAME = "admin";
    private static final String KNOWN_PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        // Check if the provided credentials match the known credentials
        if (username.equals(KNOWN_USERNAME) && password.equals(KNOWN_PASSWORD)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        validateCredentials("admin", "password"); // should return true
        validateCredentials("admin", "wrong_password"); // should return false
    }
}