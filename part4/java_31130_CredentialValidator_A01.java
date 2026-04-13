public class java_31130_CredentialValidator_A01 {

    // Interface for the Credential Validator
    public interface Validator {
        boolean validate(String username, String password);
    }

    // The validator
    private Validator validator;

    public java_31130_CredentialValidator_A01(Validator validator) {
        this.validator = validator;
    }

    public boolean validateCredentials(String username, String password) {
        return validator.validate(username, password);
    }

    // A simple validator for demonstration purposes
    public static class SimpleValidator implements Validator {
        @Override
        public boolean validate(String username, String password) {
            // Simplified version. In real world, you'd want to use a secure hash algorithm
            // and compare the hash of the password to a stored hash.
            return username.equals("admin") && password.equals("password");
        }
    }

    public static void main(String[] args) {
        // Create a new validator
        CredentialValidator validator = new CredentialValidator(new SimpleValidator());

        // Validate credentials
        boolean valid = validator.validateCredentials("admin", "password");

        // Print the result
        System.out.println("Valid credentials: " + valid);
    }
}