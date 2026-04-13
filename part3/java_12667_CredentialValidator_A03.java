public class java_12667_CredentialValidator_A03 {

    // Pre-defined known username and password
    private static final String KNOWN_USERNAME = "admin";
    private static final String KNOWN_PASSWORD = "password";

    public boolean isValid(String username, String password) {
        // Check if the provided username and password match the known ones
        if (username.equals(KNOWN_USERNAME) && password.equals(KNOWN_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

}