public class java_02995_CredentialValidator_A08 {
    public static boolean validateCredentials(String username, String password) {
        // For simplicity, let's hard-code a username and password.
        // This is obviously not a secure way to handle credentials.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        boolean isValid = LegacyCredentialValidator.validateCredentials("admin", "password");
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}