public class java_28661_CredentialValidator_A01 {

    // Pre-defined username and password.
    private String username = "admin";
    private String password = "password";

    // Constructor
    public java_28661_CredentialValidator_A01() {
    }

    // Method to validate the credentials.
    public boolean validateCredentials(String providedUsername, String providedPassword) {
        if (providedUsername.equals(username) && providedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}