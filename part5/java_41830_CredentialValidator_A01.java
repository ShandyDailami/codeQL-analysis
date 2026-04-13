public class java_41830_CredentialValidator_A01 {
    // Constants to define the minimum and maximum length of a username and password
    private static final int MIN_USERNAME_LENGTH = 5;
    private static final int MAX_USERNAME_LENGTH = 20;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 20;

    // Validate a username and password
    public boolean validate(String username, String password) {
        // Validate the username
        if (username == null || username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH) {
            return false;
        }

        // Validate the password
        if (password == null || password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // If we've made it this far, the username and password are valid
        return true;
    }
}