public class java_34798_CredentialValidator_A01 {

    // A set of predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // The method to validate credentials
    public boolean validate(String username, String password) {
        // If the given credentials match the predefined ones
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password");
    }
}