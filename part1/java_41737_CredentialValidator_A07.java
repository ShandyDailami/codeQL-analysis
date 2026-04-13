import java.security.InvalidParameterException;

public class java_41737_CredentialValidator_A07 {

    // Custom exception for invalid parameter
    public class InvalidParameterException extends InvalidParameterException {
        public java_41737_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    // Custom exception for invalid password
    public class InvalidPasswordException extends InvalidParameterException {
        public java_41737_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    // Custom exception for invalid username
    public class InvalidUsernameException extends InvalidParameterException {
        public java_41737_CredentialValidator_A07(String message) {
            super(message);
        }
    }

    // Interface for credential validator
    public interface CredentialValidator {
        void validate(String username, String password) throws InvalidUsernameException, InvalidPasswordException;
    }

    // Sample CredentialValidator implementation
    public static class SampleCredentialValidator implements CredentialValidator {
        private String expectedUsername;
        private String expectedPassword;

        // Set expected values for validation
        public void setExpectedValues(String username, String password) {
            this.expectedUsername = username;
            this.expectedPassword = password;
        }

        // Validate credential
        @Override
        public void validate(String username, String password) throws InvalidUsernameException, InvalidPasswordException {
            if (!username.equals(expectedUsername) || !password.equals(expectedPassword)) {
                throw new InvalidUsernameException("Invalid username or password");
            }
        }
    }

    // Main program
    public static void main(String[] args) {
        SampleCredentialValidator validator = new SampleCredentialValidator();
        validator.setExpectedValues("test", "test");

        try {
            validator.validate("test", "test");
            System.out.println("Valid credentials");
        } catch (InvalidUsernameException | InvalidPasswordException e) {
            System.out.println("Invalid credentials: " + e.getMessage());
        }
    }
}