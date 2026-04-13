public class java_05831_CredentialValidator_A03 {

    // Predefined password for validation
    private static final String VALID_PASSWORD = "password";

    // Method to validate the provided password
    public boolean validatePassword(String password) {
        // If the provided password matches the predefined password, return true
        if (password.equals(VALID_PASSWORD)) {
            return true;
        }

        // If the provided password does not match the predefined password, return false
        return false;
    }
}