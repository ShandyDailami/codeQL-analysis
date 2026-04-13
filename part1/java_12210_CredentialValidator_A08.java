// CredentialValidator example with a creative and realistic application

public class java_12210_CredentialValidator_A08 {

    // A simple method to validate the password
    public boolean validatePassword(String password) {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password is complex
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            return true;
        }

        // If the password is not complex, return false
        return false;
    }

    // A simple method to validate the username
    public boolean validateUsername(String username) {
        // Check if the username is null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }

        // Check if the username contains only alphanumeric characters
        if (username.matches("^[a-zA-Z0-9]+$")) {
            return true;
        }

        // If the username contains non-alphanumeric characters, return false
        return false;
    }

    // A simple method to validate the email
    public boolean validateEmail(String email) {
        // Check if the email is null or empty
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Check if the email is in a valid format
        if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return true;
        }

        // If the email is not in a valid format, return false
        return false;
    }
}