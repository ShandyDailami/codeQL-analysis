import java.security.InvalidParameterException;

public class java_10863_CredentialValidator_A01 {
    // Define the hard-coded values
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if the provided username and password match the hard-coded values
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Access granted");
            return true;
        } else {
            System.out.println("Access denied");
            return false;
        }
    }

    // This method is used to validate a credential when a user is not currently logged in
    public boolean validateSilent(String username, String password) {
        // If the provided username and password match the hard-coded values, return true
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    // This method is used to validate a credential when a user logs out
    public void logout(String username) {
        // If the provided username matches the hard-coded value, print a message
        if (username.equals(USERNAME)) {
            System.out.println("User logged out");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method
        validator.validate("admin", "password"); // Should print "Access granted"
        validator.validate("admin", "wrong_password"); // Should print "Access denied"

        // Test the validateSilent method
        validator.validateSilent("admin", "password"); // Should print "Access granted"
        validator.validateSilent("admin", "wrong_password"); // Should print "Access denied"

        // Test the logout method
        validator.logout("admin"); // Should print "User logged out"
    }
}