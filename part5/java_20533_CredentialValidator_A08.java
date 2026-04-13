public class java_20533_CredentialValidator_A08 {

    // The minimum and maximum length for the username
    private static final int MIN_USERNAME_LENGTH = 5;
    private static final int MAX_USERNAME_LENGTH = 20;

    // The minimum and maximum length for the password
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 20;

    public boolean validateCredentials(String username, String password) {
        // First, validate the length of the username and password
        if (username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH ||
            password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // Next, check if the username contains only alphanumeric characters
        if (!username.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }

        // Finally, check if the password contains a special character
        if (!password.matches("^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$")) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}