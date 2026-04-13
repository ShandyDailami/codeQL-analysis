public class java_15736_CredentialValidator_A07 {

    // Hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Constructor is private to enforce the use of the static methods
    private java_15736_CredentialValidator_A07() {
        throw new AssertionError("Cannot instantiate this class");
    }

    // Static method to validate the credentials
    public static boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Testing the credentials
        boolean valid = CredentialValidator.validateCredentials("admin", "password");
        if (valid) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}