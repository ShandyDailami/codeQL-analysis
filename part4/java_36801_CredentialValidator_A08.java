public class java_36801_CredentialValidator_A08 {
    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static class CustomValidatorImpl implements CredentialValidator {
        @Override
        public boolean validate(String username, String password) {
            // Check if the provided username and password match the predefined values
            return username.equals(USERNAME) && password.equals(PASSWORD);
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the custom validator
        CredentialValidator validator = new CustomValidatorImpl();

        // Use the validator
        boolean isValid = validator.validate("admin", "password");

        System.out.println("Is valid: " + isValid);
    }
}