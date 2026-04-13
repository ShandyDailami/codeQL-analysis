public class java_06569_CredentialValidator_A01 {
    // Hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Compare the provided username and password with the hardcoded ones
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
}