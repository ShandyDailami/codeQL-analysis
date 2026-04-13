public class java_41258_CredentialValidator_A03 {
    // No external framework or library is used.

    public boolean isValidUsername(String username) {
        // This is a simple validation process that checks if the username is not null
        // and if it's longer than 5 characters.
        return (username != null && username.length() > 5);
    }

    public boolean isValidPassword(String password) {
        // This is another simple validation process that checks if the password is not null
        // and if it's longer than 8 characters.
        return (password != null && password.length() > 8);
    }

    public boolean isValidEmail(String email) {
        // This is another simple validation process that checks if the email is not null
        // and if it follows a basic email format (e.g., abc@xyz.com).
        return (email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$"));
    }

    public boolean validateCredentials(String username, String password, String email) {
        // If all credentials are valid, return true, otherwise return false.
        return isValidUsername(username) && isValidPassword(password) && isValidEmail(email);
    }
}