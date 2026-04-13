public class java_37135_CredentialValidator_A03 {
    // Define the username and password
    private String username = "admin";
    private String password = "password";

    // Define the actual username and password
    private String actualUsername;
    private String actualPassword;

    // Credentials for testing
    private String testUsername = "admin";
    private String testPassword = "password";

    public java_37135_CredentialValidator_A03() {
        // Initialize the actual username and password
        actualUsername = System.getProperty("user.name");
        actualPassword = System.getProperty("user.password");
    }

    public boolean validateCredentials(String inputUsername, String inputPassword) {
        // Check if the input username and password match
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Credentials are correct!");
            return true;
        } else {
            System.out.println("Credentials are incorrect!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a new CredentialValidator object
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        validator.validateCredentials(validator.actualUsername, validator.actualPassword);
        validator.validateCredentials(validator.testUsername, validator.testPassword);
    }
}