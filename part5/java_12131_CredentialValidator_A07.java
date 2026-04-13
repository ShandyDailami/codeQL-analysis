public class java_12131_CredentialValidator_A07 {
    // This is a set of hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // If the username and password match, return true
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }

        // Otherwise, return false
        return false;
    }

    public static void main(String[] args) {
        // Try to validate with some credentials
        boolean isValid = validate("admin", "password");
        System.out.println("Is valid: " + isValid);
    }
}