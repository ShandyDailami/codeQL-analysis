public class java_21528_CredentialValidator_A01 {

    // Define some predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // The method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the predefined credentials
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true; // Credentials are valid
        } else {
            return false; // Credentials are invalid
        }
    }
}