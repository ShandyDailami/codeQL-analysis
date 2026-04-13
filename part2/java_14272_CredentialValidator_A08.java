public class java_14272_CredentialValidator_A08 {

    private String hardCodedPassword = "password";

    public boolean validateCredentials(String password) {
        // Check if the password is correct
        if (password != null && password.equals(hardCodedPassword)) {
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Test the validator with a correct password
        validator.validateCredentials("password");

        // Test the validator with an incorrect password
        validator.validateCredentials("incorrectPassword");
    }
}