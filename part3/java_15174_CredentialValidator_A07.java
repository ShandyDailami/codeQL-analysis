import java.util.Base64;
import java.util.UUID;

public class java_15174_CredentialValidator_A07 {
    private static final String AUTH_FAILURE_PATTERN = "A07_AuthFailure";

    public static class AuthFailureException extends Exception {
        public java_15174_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    public interface CredentialValidator {
        UserCredentials validate(Credential credential) throws AuthFailureException;
    }

    public static class UserCredentials {
        private final String sessionId;
        private final String userId;

        public java_15174_CredentialValidator_A07(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUserId() {
            return userId;
        }
    }

    public static class Credential {
        private final String username;
        private final String password;

        public java_15174_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class SimpleCredentialValidator implements CredentialValidator {
        @Override
        public UserCredentials validate(Credential credential) throws AuthFailureException {
            String password = new String(Base64.getDecoder().decode(credential.getPassword()));

            if (AUTH_FAILURE_PATTERN.equals(password)) {
                throw new AuthFailureException("Authentication failure");
            }

            String sessionId = UUID.randomUUID().toString();
            return new UserCredentials(sessionId, "userId");
        }
    }

    public static void main(String[] args) {
        try {
            Credential credential = new Credential("user", "cGFzc3dvcmQ=");  // Base64 of "password"
            CredentialValidator validator = new SimpleCredentialValidator();
            UserCredentials userCredentials = validator.validate(credential);

            System.out.println("Session Id: " + userCredentials.getSessionId());
            System.out.println("User Id: " + userCredentials.getUserId());
        } catch (AuthFailureException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}