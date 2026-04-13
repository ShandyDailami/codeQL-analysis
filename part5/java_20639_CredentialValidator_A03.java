public class java_20639_CredentialValidator_A03 {

    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // No constructor needed
    private java_20639_CredentialValidator_A03() {
        throw new UnsupportedOperationException();
    }

    // CredentialValidator method
    public static boolean validate(String username, String password) {
        // Validate the provided username and password against the hard-coded credentials
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}