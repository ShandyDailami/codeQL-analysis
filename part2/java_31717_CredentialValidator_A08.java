public class java_31717_CredentialValidator_A08 {

    // Hard-coded username and passwords
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the username and password
    public boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing valid credentials
        boolean isValid = validator.validate("admin", "password");
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }

        // Testing invalid credentials
        isValid = validator.validate("test", "wrongpassword");
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}