public class java_20070_CredentialValidator_A03 {

    // Define a hard-coded set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Define a hard-coded set of allowed credentials
    private static final String ALLOWED_USERNAME = "admin";
    private static final String ALLOWED_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the credentials match the hard-coded rules
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }

        // Check if the username is in the allowed list
        if (username.equals(ALLOWED_USERNAME)) {
            return false;
        }

        // Check if the password is in the allowed list
        if (password.equals(ALLOWED_PASSWORD)) {
            return false;
        }

        // If none of the above checks pass, return false
        return false;
    }
}