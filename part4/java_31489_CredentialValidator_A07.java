public class java_31489_CredentialValidator_A07 {

    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // No constructor for testing
    private java_31489_CredentialValidator_A07() {}

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false; // return false if either field is null
        }
        // Compare the username and password with the hard-coded ones
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}