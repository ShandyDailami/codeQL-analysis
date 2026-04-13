public class java_16042_CredentialValidator_A01 {
    private String username;
    private String password;

    // Constructor
    public java_16042_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to validate credentials
    public boolean validate() {
        // Define the expected credentials
        String expectedUsername = "admin";
        String expectedPassword = "password";

        // Check if the provided credentials match the expected credentials
        if (this.username.equals(expectedUsername) && this.password.equals(expectedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}