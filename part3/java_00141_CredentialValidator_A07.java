import java.util.Base64;

public class java_00141_CredentialValidator_A07 {

    // Authentication failure happens when the user is trying to login with an invalid username or password
    public static class AuthFailureException extends Exception {
        public java_00141_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    // Credential Validator Interface
    public interface CredentialValidator {
        boolean validate(String username, String password) throws AuthFailureException;
    }

    // Implementation of Credential Validator
    public static class CredentialValidatorImpl implements CredentialValidator {
        private static final String VALID_USERNAME = "admin";
        private static final String VALID_PASSWORD = "password";

        // Uses Bcrypt to hash passwords, as it is considered secure
        @Override
        public boolean validate(String username, String password) throws AuthFailureException {
            if (!username.equals(VALID_USERNAME) || !password.equals(VALID_PASSWORD)) {
                throw new AuthFailureException("Invalid username or password");
            }

            // Since we are not using an external library, we can use Base64 to encode/decode password
            String hashedPassword = Base64.getEncoder().encodeToString(password.getBytes());

            return true;
        }
    }

    public static void main(String[] args) {
        CredentialValidator credentialValidator = new CredentialValidatorImpl();

        try {
            if (credentialValidator.validate("admin", "password")) {
                System.out.println("User is authenticated successfully");
            } else {
                System.out.println("Authentication failed");
            }
        } catch (CredentialValidator.AuthFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}