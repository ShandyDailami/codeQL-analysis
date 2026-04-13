public class java_08234_CredentialValidator_A03 {

    // Hard-coded set of rules
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // If the username matches a hard-coded set of rules
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true; // Validate the credentials
        } else {
            return false; // Invalidate the credentials
        }
    }
}