public class java_30813_CredentialValidator_A03 {

    // Method to check if the given username is valid
    public boolean isValidUsername(String username) {
        // Check if username is null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }
        // Check if username contains only alphanumeric characters
        if (!username.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }
        return true;
    }

    // Method to check if the given password is valid
    public boolean isValidPassword(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }
        // Check if password contains only alphanumeric characters and special characters
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            return false;
        }
        return true;
    }

    // Method to validate the given credentials
    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}