public class java_16615_CredentialValidator_A01 {
    // Expected values
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    // The actual username and password
    private String actualUsername;
    private String actualPassword;

    // Constructor
    public java_16615_CredentialValidator_A01(String actualUsername, String actualPassword) {
        this.actualUsername = actualUsername;
        this.actualPassword = actualPassword;
    }

    // Method to validate the credentials
    public boolean validateCredentials() {
        if (this.actualUsername.equals(EXPECTED_USERNAME) && this.actualPassword.equals(EXPECTED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}