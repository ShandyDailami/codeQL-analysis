public class java_08437_CredentialValidator_A01 {

    // Constants for password complexity
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._%+-]{3,}$";

    // Method to validate password
    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    // Method to validate username
    public boolean validateUsername(String username) {
        return username.matches(USERNAME_REGEX);
    }

    // Method to validate both username and password
    public boolean validateCredentials(String username, String password) {
        return validateUsername(username) && validatePassword(password);
    }
}