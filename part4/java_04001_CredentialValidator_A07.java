public class java_04001_CredentialValidator_A07 {

    // Define the predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // The actual credential to validate against
    private String userEnteredUsername;
    private String userEnteredPassword;

    public java_04001_CredentialValidator_A07(String userEnteredUsername, String userEnteredPassword) {
        this.userEnteredUsername = userEnteredUsername;
        this.userEnteredPassword = userEnteredPassword;
    }

    // Method to validate the credentials
    public boolean validate() {
        return this.userEnteredUsername.equals(USERNAME) && this.userEnteredPassword.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.validate()); // Prints true if valid, false otherwise
    }
}