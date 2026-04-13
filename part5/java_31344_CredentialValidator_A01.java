public class java_31344_CredentialValidator_A01 {
    private String username;
    private String password;

    // Constructor
    public java_31344_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate credentials
    public boolean validateCredentials() {
        // Hard-coded credentials for simplicity
        String hardCodedUsername = "admin";
        String hardCodedPassword = "password";

        // Check if both username and password match hard-coded credentials
        if (this.username.equals(hardCodedUsername) && this.password.equals(hardCodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}