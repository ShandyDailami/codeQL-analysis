public class java_36089_CredentialValidator_A08 {

    // A method to validate password
    public boolean validatePassword(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password length is more than 8 characters
        if (password.length() > 8) {
            return true;
        }

        // If password length is less than 8 characters, return false
        return false;
    }

    // A method to validate username
    public boolean validateUsername(String username) {
        // Check if username is null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }

        // Check if username length is more than 4 characters
        if (username.length() > 4) {
            return true;
        }

        // If username length is less than 4 characters, return false
        return false;
    }
}