public class java_17915_CredentialValidator_A08 {

    // Predefined username and password
    private String predefinedUsername = "admin";
    private String predefinedPassword = "password";

    // Credentials received from the user
    private String inputUsername;
    private String inputPassword;

    // Constructor
    public java_17915_CredentialValidator_A08(String inputUsername, String inputPassword) {
        this.inputUsername = inputUsername;
        this.inputPassword = inputPassword;
    }

    // Method to check the credentials
    public boolean checkCredentials() {
        // If the input credentials match the predefined credentials, return true
        if (inputUsername.equals(predefinedUsername) && inputPassword.equals(predefinedPassword)) {
            return true;
        } else {
            // If the input credentials do not match the predefined credentials, return false
            return false;
        }
    }
}