public class java_19243_CredentialValidator_A01 {

    // Hard-coded rules
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public static boolean validate(String username, String password) {
        // In a real application, you would want to have a more robust way of handling
        // invalid credentials, such as returning an error status or logging the error.
        // For the sake of simplicity, we'll just return false in this example.

        // The simple validation
        return (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD));
    }

}