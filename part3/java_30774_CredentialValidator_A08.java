public class java_30774_CredentialValidator_A08 {
    // Predefined credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        // If the username and password match the predefined values
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        boolean result = CredentialValidator.validateCredentials("user", "password");

        if (result) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}