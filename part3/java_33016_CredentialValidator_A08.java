public class java_33016_CredentialValidator_A08 {

    // Expected credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Current credentials
    private String currentUsername;
    private String currentPassword;

    public java_33016_CredentialValidator_A08(String currentUsername, String currentPassword) {
        this.currentUsername = currentUsername;
        this.currentPassword = currentPassword;
    }

    public boolean isValid() {
        // Compare expected and current credentials
        return this.currentUsername.equals(USERNAME) && this.currentPassword.equals(PASSWORD);
    }
}