public class java_01265_CredentialValidator_A03 {

    // Step 1: Define a custom exception for invalid credential
    public static class InvalidCredentialException extends Exception {
        public java_01265_CredentialValidator_A03(String message) {
            super(message);
        }
    }

    // Step 2: Define an interface for credential validator
    public interface CredentialValidator {
        boolean isValid(String username, String password) throws InvalidCredentialException;
    }

    // Step 3: Define a credential validator class that implements the interface
    public static class CredentialValidatorImpl implements CredentialValidator {
        public boolean isValid(String username, String password) throws InvalidCredentialException {
            // Step 4: Simulate checking if username and password are correct
            // This is a simple example and in a real world application, the actual method to check credentials would be much more complex.
            if (username.equals("admin") && password.equals("password")) {
                return true;
            } else {
                throw new InvalidCredentialException("Invalid username or password");
            }
        }
    }

    // Step 5: Use the credential validator
    public static void main(String[] args) {
        CredentialValidator credentialValidator = new CredentialValidatorImpl();
        try {
            if (credentialValidator.isValid("admin", "password")) {
                System.out.println("Credentials are valid");
            } else {
                System.out.println("Credentials are not valid");
            }
        } catch (InvalidCredentialException e) {
            System.out.println(e.getMessage());
        }
    }
}