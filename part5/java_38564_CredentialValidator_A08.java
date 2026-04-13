public class java_38564_CredentialValidator_A08 {

    // This is a simple hard-coded pattern for testing purposes.
    // In a real-world application, you would use a more complex pattern.
    private static final String VALID_PATTERN = "admin";

    public boolean validate(String password) {
        return password.equals(VALID_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing
        System.out.println(validator.validate("admin")); // Should print: true
        System.out.println(validator.validate("test"));  // Should print: false
    }
}