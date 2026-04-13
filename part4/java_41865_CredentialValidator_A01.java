public class java_41865_CredentialValidator_A01 {

    // Hard-coded username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String enteredUsername, String enteredPassword) {
        // If the entered username and password match the hard-coded ones
        if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
            System.out.println("Credentials are correct.");
            return true; // Sign in successful
        } else {
            System.out.println("Credentials are incorrect.");
            return false; // Sign in failed
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing
        validator.validate("admin", "password");
        validator.validate("admin", "wrongpassword");
    }
}