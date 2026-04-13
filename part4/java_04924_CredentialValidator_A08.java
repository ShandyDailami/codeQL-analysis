public class java_04924_CredentialValidator_A08 {

    // Hard-coded credentials.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // No constructor for security reasons.
    private java_04924_CredentialValidator_A08() {
        throw new AssertionError("Cannot instantiate a CredentialValidator");
    }

    public static boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

}