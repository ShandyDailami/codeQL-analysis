public class java_31547_CredentialValidator_A03 {
    // Define a mock user for validation
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Check if the provided credentials match the mock user
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // If they match, return true
            return true;
        } else {
            // If they don't match, return false
            return false;
        }
    }
}