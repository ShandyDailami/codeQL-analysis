public class java_32129_CredentialValidator_A08 {

    // The password pattern we're checking against
    private static final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)";

    // Main method for testing
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        System.out.println(validator.validate("Test@123")); // returns true
        System.out.println(validator.validate("test@123")); // returns false
    }

    // Validate method
    public boolean validate(String password) {
        // Check if password matches the pattern
        return password.matches(PASSWORD_PATTERN);
    }
}