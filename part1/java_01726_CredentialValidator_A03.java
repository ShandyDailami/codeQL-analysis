public class java_01726_CredentialValidator_A03 {

    // Define a hardcoded username and password
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the hardcoded credentials
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            return true; // Credentials are correct, return true
        } else {
            return false; // Credentials are incorrect, return false
        }
    }
}