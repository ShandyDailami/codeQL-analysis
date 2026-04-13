public class java_12422_CredentialValidator_A07 {

    // CredentialValidator Interface
    interface CredentialValidator {
        boolean isValid(String username, String password);
    }

    // CredentialValidator Implementation
    static class SecureCredentialValidator implements CredentialValidator {
        private final String secureUsername;
        private final String securePassword;

        public java_12422_CredentialValidator_A07(String secureUsername, String securePassword) {
            this.secureUsername = secureUsername;
            this.securePassword = securePassword;
        }

        @Override
        public boolean isValid(String username, String password) {
            return secureUsername.equals(username) && securePassword.equals(password);
        }
    }

    // Authenticator Interface
    interface Authenticator {
        boolean authenticate(String username, String password);
    }

    // Authenticator Implementation
    static class SecureAuthenticator implements Authenticator {
        private final CredentialValidator validator;

        public java_12422_CredentialValidator_A07(CredentialValidator validator) {
            this.validator = validator;
        }

        @Override
        public boolean authenticate(String username, String password) {
            return validator.isValid(username, password);
        }
    }

    // Main Method
    public static void main(String[] args) {
        // Create a secure CredentialValidator
        CredentialValidator validator = new SecureCredentialValidator("secureUsername", "securePassword");

        // Create a secure Authenticator using the secure CredentialValidator
        Authenticator authenticator = new SecureAuthenticator(validator);

        // Authenticate
        boolean isAuthenticated = authenticator.authenticate("secureUsername", "securePassword");

        // Print the result
        System.out.println("Is authenticated? " + isAuthenticated);
    }
}