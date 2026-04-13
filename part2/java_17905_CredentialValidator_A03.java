public class java_17905_CredentialValidator_A03 {
    // This is a dummy validator, it just checks if the username and password match some hard-coded values
    public boolean validate(String username, String password) {
        // Hard-coded credentials
        String expectedUsername = "admin";
        String expectedPassword = "password";

        // Check if the credentials match
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
}