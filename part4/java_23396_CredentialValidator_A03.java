public class java_23396_CredentialValidator_A03 {

    // Predefined allowed usernames and passwords.
    private static final String ALLOWED_USERNAME = "admin";
    private static final String ALLOWED_PASSWORD = "password";

    public boolean validate(String username, String password) {
        // If the provided username and password match the allowed ones, return true.
        // Otherwise, return false.
        if (username.equals(ALLOWED_USERNAME) && password.equals(ALLOWED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}