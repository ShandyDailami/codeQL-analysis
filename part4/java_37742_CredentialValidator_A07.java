public class java_37742_CredentialValidator_A07 {
    // Hardcoded credentials for simplicity
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public boolean validate(String inputUsername, String inputPassword) {
        // If the username or password is not provided, return false
        if (inputUsername == null || inputPassword == null) {
            return false;
        }

        // If the provided username and password are not matching with hardcoded credentials, return false
        if (!inputUsername.equals(USERNAME) || !inputPassword.equals(PASSWORD)) {
            return false;
        }

        // If all the above checks are passed, return true
        return true;
    }
}