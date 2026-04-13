public class java_35597_CredentialValidator_A08 {
    // Hardcoded password for demonstration purposes
    private static final String HARDCODED_PASSWORD = "password";

    public static class Validator implements org.eclipse.jetty.util.security.Validator {
        @Override
        public boolean validate(String schemeName, String credentials) {
            // Compare the password provided by the client with the hardcoded password
            return HARDCODED_PASSWORD.equals(credentials);
        }

        @Override
        public void invalidate(String schemeName, String message) {
            // Do nothing
        }
    }

    public static void main(String[] args) {
        // Create a new Validator instance
        org.eclipse.jetty.util.security.Validator validator = new Validator();

        // Initialize the password validator
        org.eclipse.jetty.util.security.PasswordValidator passwordValidator = new org.eclipse.jetty.util.security.PasswordValidator();
        passwordValidator.setHandler(validator);

        // Use the password validator
        String password = "wrongPassword";
        if (passwordValidator.validate(password)) {
            System.out.println("Invalid password");
        } else {
            System.out.println("Valid password");
        }
    }
}