public class java_37739_CredentialValidator_A01 {

    // Define a hard-coded password
    private static final String HARDCODED_PASSWORD = "test_password";

    // This method will validate the password
    public boolean validate(String password) {
        // If the password is the hardcoded password, return true
        if (password.equals(HARDCODED_PASSWORD)) {
            return true;
        }

        // If the password is not the hardcoded password, return false
        return false;
    }
}