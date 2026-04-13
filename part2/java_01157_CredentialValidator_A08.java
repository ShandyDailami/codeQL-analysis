public class java_01157_CredentialValidator_A08 {

    // Static set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Public method for authenticating users
    public boolean authenticate(String username, String password) {
        // Check if username and password match the predefined set
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
}