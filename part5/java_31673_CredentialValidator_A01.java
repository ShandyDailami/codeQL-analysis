public class java_31673_CredentialValidator_A01 {

    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // If the provided username and password match the hard-coded ones, return true
        // Otherwise, return false
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}