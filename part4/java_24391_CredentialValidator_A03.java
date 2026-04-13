public class java_24391_CredentialValidator_A03 {

    // Hardcoded set of credentials
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if the given username and password match the hardcoded set
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}