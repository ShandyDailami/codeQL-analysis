import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessControlException;

public class java_23001_CredentialValidator_A01 {
    public static void main(String[] args) {
        // Create a simple access control context
        AccessControl accessControl = new AccessControlContext();

        // Create a credential validator that will use the access control context
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(Credential credential) throws AccessControlException {
                // Validate the credential
                String password = credential.getPassword();
                return password.length() >= 8;
            }
        };

        // Use the validator
        String password = "password";
        try {
            if (!validator.validate(new SimpleCredential(password))) {
                System.out.println("Password is too short!");
            } else {
                System.out.println("Password is valid!");
            }
        } catch (AccessControlException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Simple credential that wraps a string password
    static class SimpleCredential implements Credential {
        private String password;

        public java_23001_CredentialValidator_A01(String password) {
            this.password = password;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }
}