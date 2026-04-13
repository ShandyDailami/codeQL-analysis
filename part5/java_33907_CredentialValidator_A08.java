public class java_33907_CredentialValidator_A08 {

    // The username and password to validate against
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if the provided username and password match
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Credentials validated.");
            return true;
        } else {
            System.out.println("Credentials not valid.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user", "password"); // Should print "Credentials validated."
        validator.validate("wrong_username", "wrong_password"); // Should print "Credentials not valid."
    }
}