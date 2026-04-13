public class java_04476_CredentialValidator_A08 {
    // Predefined valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    // Check if the username and password match the predefined set
    public boolean validate(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }

    // Main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        boolean isValid = validator.validate("admin", "password");
        System.out.println("Is valid: " + isValid);

        // Test invalid credentials
        isValid = validator.validate("invalid", "invalid");
        System.out.println("Is valid: " + isValid);
    }
}