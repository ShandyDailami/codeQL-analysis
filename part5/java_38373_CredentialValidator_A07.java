public class java_38373_CredentialValidator_A07 {
    // hard-coded set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // If the provided username and password match, return true.
        // Otherwise, return false.
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}