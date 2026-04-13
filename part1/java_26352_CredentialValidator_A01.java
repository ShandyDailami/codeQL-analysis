public class java_26352_CredentialValidator_A01 {
    // The actual data stored in the CredentialValidator
    private String username;
    private String password;

    // Constructor
    public java_26352_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate username and password
    public boolean validateCredentials(String enteredUsername, String enteredPassword) {
        // Check if entered username and password matches the actual data
        if (enteredUsername.equals(this.username) && enteredPassword.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}