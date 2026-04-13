public class java_36519_CredentialValidator_A08 {
    // We're assuming that our credentials are valid if they match the following criteria
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // If the username and password match our valid credentials, we return true
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            // If they don't match, we return false
            return false;
        }
    }
}