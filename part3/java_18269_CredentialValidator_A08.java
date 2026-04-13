public class java_18269_CredentialValidator_A08 {

    // Set of expected username and passwords
    private static final String EXPECTED_USERNAME = "testuser";
    private static final String EXPECTED_PASSWORD = "testpassword";

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the expected values
        if (username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}