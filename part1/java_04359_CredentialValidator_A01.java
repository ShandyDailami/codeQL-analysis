public class java_04359_CredentialValidator_A01 {
    private String expectedUsername;
    private String expectedPassword;

    // constructor
    public java_04359_CredentialValidator_A01(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    // method to validate the credentials
    public boolean validateCredentials(String providedUsername, String providedPassword) {
        if (providedUsername == null || providedPassword == null) {
            return false;
        }

        if (providedUsername.equals(expectedUsername) && providedPassword.equals(expectedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}