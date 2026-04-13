public class java_41172_CredentialValidator_A08 {

    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // This method will validate the credentials
    public boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true; // Credentials are valid
        } else {
            return false; // Credentials are not valid
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        boolean valid = validator.validate("admin", "password");
        if (valid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}