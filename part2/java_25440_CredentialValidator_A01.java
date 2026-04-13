public class java_25440_CredentialValidator_A01 {
    // Define the interface for a credential validator
    public interface CredentialValidator {
        boolean validate(String username, String password);
    }

    // Implement the CredentialValidator interface
    public class BasicCredentialValidator implements CredentialValidator {
        private String[][] credentials = {
            {"admin", "password123"},
            {"user", "password"},
            {"admin", "invalid"}
        };

        @Override
        public boolean validate(String username, String password) {
            for (int i = 0; i < credentials.length; i++) {
                if (credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the CredentialValidator
        CredentialValidator validator = new BasicCredentialValidator();

        // Validate a username and password
        System.out.println(validator.validate("admin", "password123")); // Returns true
        System.out.println(validator.validate("user", "password")); // Returns true
        System.out.println(validator.validate("admin", "invalid")); // Returns false
    }
}