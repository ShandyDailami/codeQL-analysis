public class java_33091_CredentialValidator_A01 {

    // Define a hardcoded username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Validate the username and password
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method with some credentials
        System.out.println(validator.validate("admin", "password")); // Outputs: true
        System.out.println(validator.validate("admin", "wrong_password")); // Outputs: false
        System.out.println(validator.validate("wrong_username", "password")); // Outputs: false
        System.out.println(validator.validate(null, null)); // Outputs: false
        System.out.println(validator.validate("wrong_username", "wrong_password")); // Outputs: false
    }
}