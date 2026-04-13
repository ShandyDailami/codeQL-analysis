public class java_06080_CredentialValidator_A01 {

    // hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // if the given usernames and passwords match the hard-coded ones
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }

        // if the given usernames and passwords don't match the hard-coded ones
        return false;
    }

    public static void main(String[] args) {
        // test the validation
        boolean isValid = validate("admin", "password");
        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}