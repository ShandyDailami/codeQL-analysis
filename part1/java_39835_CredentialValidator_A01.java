public class java_39835_CredentialValidator_A01 {

    // Define a hardcoded set of valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Check if the provided username and password match the hardcoded set values
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}