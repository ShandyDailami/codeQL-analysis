public class java_30273_CredentialValidator_A03 {
    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if the given username and password match the hard-coded values
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
}