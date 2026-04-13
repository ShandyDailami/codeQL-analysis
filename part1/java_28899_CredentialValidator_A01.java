public class java_28899_CredentialValidator_A01 {

    // Interface for credential validation
    public interface CredentialValidator {
        boolean isValid(String username, String password);
    }

    // Insecure CredentialValidator implementation
    public class InsecureCredentialValidator implements CredentialValidator {

        private static final String USERNAME = "admin";
        private static final String PASSWORD = "password";

        @Override
        public boolean isValid(String username, String password) {
            return username.equals(USERNAME) && password.equals(PASSWORD);
        }
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        CredentialValidator validator = new InsecureCredentialValidator();

        // Testing the validator
        String username = "admin";
        String password = "password";
        if (validator.isValid(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}