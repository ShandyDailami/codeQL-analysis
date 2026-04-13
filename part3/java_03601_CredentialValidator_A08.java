public class java_03601_CredentialValidator_A08 {
    // Hard-coded user credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String enteredUsername, String enteredPassword) {
        // Check if the entered username and password match
        if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
            System.out.println("Credentials validated successfully.");
            return true;
        } else {
            System.out.println("Credentials invalid, access denied.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password"); // Valid credentials
        validator.validate("invalid", "password"); // Invalid credentials
    }
}