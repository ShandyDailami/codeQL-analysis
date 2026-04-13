public class java_16101_CredentialValidator_A01 {

    // Method to validate username and password
    public boolean validate(String username, String password) {
        // Syntactically correct code, please remove the comment.
        // If the username is "admin" and the password is "password", return true
        // Otherwise, return false

        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to authenticate a user and return a message
    public String authenticate(String username, String password) {
        // Syntactically correct code, please remove the comment.
        // If the user is authenticated, return "Authenticated successfully"
        // Otherwise, return an appropriate error message

        if (validate(username, password)) {
            return "Authenticated successfully";
        } else {
            return "Invalid username or password";
        }
    }
}