public class java_36147_CredentialValidator_A03 {

    // Pre-defined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if the provided username and password match the pre-defined credentials
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        
        // Testing
        System.out.println("Is valid? " + validator.validate("admin", "password")); // Should print: true
        System.out.println("Is valid? " + validator.validate("invalid", "invalid")); // Should print: false
    }
}