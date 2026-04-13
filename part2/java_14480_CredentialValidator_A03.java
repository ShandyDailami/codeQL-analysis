public class java_14480_CredentialValidator_A03 {
    // Constant to indicate successful authentication.
    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful.";

    // Constant to indicate failed authentication.
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed.";

    // Constant to indicate a missing username.
    private static final String MISSING_USERNAME = "Missing username.";

    // Constant to indicate a missing password.
    private static final String MISSING_PASSWORD = "Missing password.";

    // Method to validate the credentials.
    public String validate(String userName, String password) {
        // Check for missing username.
        if (userName == null) {
            return MISSING_USERNAME;
        }

        // Check for missing password.
        if (password == null) {
            return MISSING_PASSWORD;
        }

        // Here you would normally connect to a database or another security service
        // to verify the user's credentials. This is a simple example, in a real-world
        // application you would not store passwords in plain text.

        // For the sake of simplicity, we'll just check if the userName is "admin"
        // and the password is "password".
        if ("admin".equals(userName) && "password".equals(password)) {
            return AUTHENTICATION_SUCCESS;
        } else {
            return AUTHENTICATION_FAILURE;
        }
    }
}