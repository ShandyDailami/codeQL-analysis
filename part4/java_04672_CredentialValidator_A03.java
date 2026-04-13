public class java_04672_CredentialValidator_A03 {

    // Define a pattern for the password
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    // Instance variable to hold the input username
    private String username;

    // Instance variable to hold the input password
    private String password;

    // Constructor to initialize the username
    public java_04672_CredentialValidator_A03(String username) {
        this.username = username;
    }

    // Method to set the password
    public void setPassword(String password) {
        this.password = password;
    }

    // Method to validate the username and password
    public boolean validate() {
        // Check if the username is not null
        if (this.username == null) {
            return false;
        }

        // Check if the password is not null
        if (this.password == null) {
            return false;
        }

        // Check if the username contains only alphanumeric characters
        if (!this.username.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        // Check if the password matches the predefined pattern
        if (!this.password.matches(PASSWORD_PATTERN)) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}