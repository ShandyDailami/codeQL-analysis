public class java_16023_CredentialValidator_A07 {

    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // If the provided username and password match the hard-coded credentials, return true
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }

        // If the provided username and password don't match the hard-coded credentials, return false
        return false;
    }

    public static void main(String[] args) {
        // Testing the validate method
        boolean result = validate("admin", "password");
        System.out.println("Credentials are valid: " + result);
    }
}