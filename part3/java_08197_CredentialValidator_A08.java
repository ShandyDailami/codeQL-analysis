public class java_08197_CredentialValidator_A08 {
    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Public method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}