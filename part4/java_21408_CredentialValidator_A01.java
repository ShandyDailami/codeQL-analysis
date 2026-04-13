public class java_21408_CredentialValidator_A01 {
    // Define a username and password for validation
    private String validUsername = "admin";
    private String validPassword = "password";

    // Create a method to check if the provided username and password match
    public boolean validate(String username, String password) {
        // If the provided username and password match, return true
        if (username.equals(validUsername) && password.equals(validPassword)) {
            return true;
        } else {
            // Otherwise, return false
            return false;
        }
    }
}