public class java_07884_CredentialValidator_A03 {

    // This method checks if the username is valid.
    // It returns true if the username is non-empty and is alphanumeric, false otherwise.
    public boolean isUsernameValid(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }

        // Check if username is alphanumeric
        for (char c : username.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }

    // This method checks if the password is valid.
    // It returns true if the password is non-empty and is at least 8 characters long, false otherwise.
    public boolean isPasswordValid(String password) {
        if (password == null || password.trim().isEmpty() || password.length() < 8) {
            return false;
        }

        return true;
    }

    // This method validates the username and password.
    // It returns a string with the result of the validation.
    public String validateCredentials(String username, String password) {
        if (!isUsernameValid(username)) {
            return "Username is invalid.";
        }

        if (!isPasswordValid(password)) {
            return "Password is invalid.";
        }

        return "Credentials are valid.";
    }
}