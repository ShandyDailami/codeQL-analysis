public class java_30343_CredentialValidator_A01 {
    // This is the hardcoded username and password.
    // In a real-world application, these should be stored securely and retrieved from a secure source.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validateCredentials(String username, String password) {
        // Check if the provided credentials match the hardcoded ones.
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}