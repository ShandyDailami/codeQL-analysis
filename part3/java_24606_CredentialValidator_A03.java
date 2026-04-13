public class java_24606_CredentialValidator_A03 {

    // Method to validate username
    public boolean validateUsername(String username) {
        // Check if the username is null
        if (username == null) {
            return false;
        }

        // Check if the username is not alphanumeric
        if (!username.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        // Check if the username is not greater than 5 characters
        if (username.length() <= 5) {
            return false;
        }

        // If all conditions are satisfied, return true
        return true;
    }
}