public class java_03661_CredentialValidator_A01 {

    // A method for username and password validation.
    // Returns a boolean value indicating if the credentials are valid.
    public boolean validateCredentials(String username, String password) {
        // Define valid usernames and passwords.
        String validUsername = "admin";
        String validPassword = "password";

        // Check if the provided credentials match our valid credentials.
        if (username.equals(validUsername) && password.equals(validPassword)) {
            return true; // Return true if the credentials are valid.
        } else {
            return false; // Return false if the credentials are invalid.
        }
    }
}