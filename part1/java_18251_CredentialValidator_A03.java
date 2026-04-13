public class java_18251_CredentialValidator_A03 {

    // Hard-coded credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    // Method to validate credentials
    public boolean validate(String username, String password) {
        // Check if the entered username and password match the hard-coded ones
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Credentials invalid!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user", "password"); // Should print "Credentials validated successfully!"
        validator.validate("wrong_user", "wrong_password"); // Should print "Credentials invalid!"
    }
}