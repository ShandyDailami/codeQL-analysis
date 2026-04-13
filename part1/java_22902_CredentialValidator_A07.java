import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_22902_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    // Set of roles that can access the system
    private Set<String> allowedRoles = new HashSet<>(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));

    @Override
    public Subject getSubject(CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException {
        // Callback to handle the username and password
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new UsernameCallback("user");
        callbacks[1] = new PasswordCallback("password", true); // Password is sensitive
        callbackHandler.handle(callbacks);
        return null; // In this example, there is no subject
    }

    @Override
    public boolean validate(Subject subject, String role) throws IllegalArgumentException {
        // Check if the role is in the allowed roles
        return allowedRoles.contains(role);
    }

    // Implementing Callback for username and password
    private static class UsernameCallback implements Callback {
        private String username;

        public java_22902_CredentialValidator_A07(String username) {
            this.username = username;
        }

        @Override
        public void setCallbackType(String callbackType) {
            // Not needed in our case
        }

        @Override
        public String getCallerName() {
            return "Unknown Caller";
        }

        @Override
        public String getUsername() {
            return this.username;
        }

        @Override
        public String getPassword() {
            return null; // No password for this callback
        }
    }

    private static class PasswordCallback implements Callback {
        private String password;
        private boolean isPasswordToBeEncrypted;

        public java_22902_CredentialValidator_A07(String password, boolean isPasswordToBeEncrypted) {
            this.password = password;
            this.isPasswordToBeEncrypted = isPasswordToBeEncrypted;
        }

        @Override
        public void setCallbackType(String callbackType) {
            // Not needed in our case
        }

        @Override
        public String getCallerName() {
            return "Unknown Caller";
        }

        @Override
        public String getUsername() {
            return null; // No username for this callback
        }

        @Override
        public String getPassword() {
            if (isPasswordToBeEncrypted) {
                // Return the encrypted password here
                // For simplicity, we return the password itself
                return password;
            } else {
                return password; // Return the decrypted password
            }
        }
    }
}