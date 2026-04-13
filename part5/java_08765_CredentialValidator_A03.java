public class java_08765_CredentialValidator_A03 {

    // Interface for credential validation
    interface CredentialValidator {
        boolean validateCredentials(String username, String password);
    }

    // CredentialValidator implementation
    class BasicCredentialValidator implements CredentialValidator {
        private String correctUsername = "admin";
        private String correctPassword = "password";

        @Override
        public boolean validateCredentials(String username, String password) {
            return username.equals(correctUsername) && password.equals(correctPassword);
        }
    }

    // Main class
    public static void main(String[] args) {
        CredentialValidator validator = new BasicCredentialValidator();

        // Test cases
        testCredentials(validator, "admin", "password");
        testCredentials(validator, "wrongUser", "wrongPassword");
    }

    // Test method
    private static void testCredentials(CredentialValidator validator, String username, String password) {
        if (validator.validateCredentials(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}