public class java_28757_CredentialValidator_A01 {

    // predefined username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // method to validate the username and password
    public boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // use the validator to validate the credentials
        boolean isValid = validator.validateCredentials("admin", "password");

        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}