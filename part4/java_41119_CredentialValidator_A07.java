public class java_41119_CredentialValidator_A07 {

    // Define hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // This is a mock for a system that attempts to authenticate the user.
    // It takes in a username and password and returns a boolean.
    public boolean authenticate(String username, String password) {
        // If the username and password match hard-coded values, return true.
        // Otherwise, return false.
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // This method takes a username and password and validates them.
    // It returns true if the username and password are valid, false otherwise.
    public boolean validateCredentials(String username, String password) {
        // If the user is authenticated, return true.
        // Otherwise, return false.
        return authenticate(username, password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validateCredentials("admin", "password");
        System.out.println("Is valid: " + isValid);
    }
}