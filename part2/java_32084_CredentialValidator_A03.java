public class java_32084_CredentialValidator_A03 {

    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Credentials to validate
    private String enteredUsername;
    private String enteredPassword;

    public java_32084_CredentialValidator_A03(String username, String password) {
        this.enteredUsername = username;
        this.enteredPassword = password;
    }

    public boolean validate() {
        // Check if entered credentials match predefined credentials
        if (this.enteredUsername.equals(USERNAME) && this.enteredPassword.equals(PASSWORD)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Credentials invalid. Please try again.");
            return false;
        }
    }

    // Setter for entered username
    public void setEnteredUsername(String enteredUsername) {
        this.enteredUsername = enteredUsername;
    }

    // Setter for entered password
    public void setEnteredPassword(String enteredPassword) {
        this.enteredPassword = enteredPassword;
    }

}