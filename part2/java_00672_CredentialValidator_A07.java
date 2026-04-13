public class java_00672_CredentialValidator_A07 {

    // Define the predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // CredentialValidator interface
    public interface CredentialValidator extends Validator {
        boolean validate(String username, String password);
    }

    // CredentialValidator implementation
    public static class CredentialValidatorImpl implements CredentialValidator {

        @Override
        public boolean validate(String username, String password) {
            return USERNAME.equals(username) && PASSWORD.equals(password);
        }
    }

    public static void main(String[] args) {
        // Create a CredentialValidator instance
        CredentialValidator validator = new CredentialValidatorImpl();

        // Use the validator to authenticate a user
        boolean authenticated = validator.validate("admin", "password");
        if (authenticated) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}