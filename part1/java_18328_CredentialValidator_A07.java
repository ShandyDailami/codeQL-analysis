public class java_18328_CredentialValidator_A07 {

    // Hard-coded credentials
    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    public boolean isValidCredentials(String providedUsername, String providedPassword) {
        // Check if provided credentials match hard-coded credentials
        if (providedUsername.equals(USERNAME) && providedPassword.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}