public class java_00605_CredentialValidator_A01 {

    // Define the hard-coded username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Define the actual username and password to be compared with
    private String actualUsername;
    private String actualPassword;

    // Constructor
    public java_00605_CredentialValidator_A01(String actualUsername, String actualPassword) {
        this.actualUsername = actualUsername;
        this.actualPassword = actualPassword;
    }

    // Method that validates the credentials
    public boolean validate() {
        return actualUsername.equals(USERNAME) && actualPassword.equals(PASSWORD);
    }

}

// Test the CredentialValidator
public class Main {
    public static void main(String[] args) {
        // Create a CredentialValidator with hard-coded credentials
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Validate the credentials
        boolean isValid = validator.validate();

        // Print the result
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}