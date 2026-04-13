public class java_25339_CredentialValidator_A08 {

    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validateCredentials(String username, String password) {
        // If the provided username and password match our hard-coded ones, return true
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }
}