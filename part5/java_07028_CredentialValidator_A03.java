public class java_07028_CredentialValidator_A03 {

    // Hardcoded username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // If the username and password match the hardcoded values, return true
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            // Otherwise, return false
            return false;
        }
    }
}