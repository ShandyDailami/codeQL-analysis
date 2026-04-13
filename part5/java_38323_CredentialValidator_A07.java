public class java_38323_CredentialValidator_A07 {

    // Hardcoded set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // This method validates the given username and password.
    public boolean validate(String inputUsername, String inputPassword) {
        return inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the validator
        boolean isValid = validator.validate("admin", "password");
        if (isValid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}