public class java_12486_CredentialValidator_A08 {

    // Regex pattern to match alphanumeric characters
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]+$";

    // Method to validate a password
    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing valid password
        System.out.println(validator.validatePassword("Password123")); // true

        // Testing invalid password
        System.out.println(validator.validatePassword("Password")); // false
    }
}