public class java_37065_CredentialValidator_A01 {

    // Define a predefined username and password
    private String username = "admin";
    private String password = "password";

    // Method to validate user credentials
    public boolean validateCredentials(String user, String pass) {
        if(user != null && user.equals(username) && pass != null && pass.equals(password)) {
            return true;
        }
        return false;
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validateCredentials method
        boolean isValid = validator.validateCredentials("admin", "password");
        if(isValid) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}