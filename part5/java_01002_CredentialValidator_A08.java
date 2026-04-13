public class java_01002_CredentialValidator_A08 {

    // Hard-coded username and password
    private static final String hardCodedUsername = "admin";
    private static final String hardCodedPassword = "password";

    // The method to validate the username and password
    public boolean validate(String username, String password) {
        // If the provided username and password match the hard-coded values
        if (username.equals(hardCodedUsername) && password.equals(hardCodedPassword)) {
            // Return true to indicate successful validation
            return true;
        } else {
            // Otherwise, return false
            return false;
        }
    }
}