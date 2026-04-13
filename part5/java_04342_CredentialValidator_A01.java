import java.util.Base64;

public class java_04342_CredentialValidator_A01 {

    // A simple credential validator that validates the username and password.
    // In a real-world application, you would probably use a more complex validation method.

    public boolean isValidCredential(String username, String password) {
        // Assume the default username and password for the example.
        // This is a simplistic way of validating credentials and is not recommended for real-world use.
        return username.equals("admin") && password.equals("password");
    }

    public void validateCredential(String username, String password) throws CredentialException {
        if (!isValidCredential(username, password)) {
            throw new CredentialException("Invalid username or password");
        }
    }

    // Custom exception for handling credential validation errors.
    class CredentialException extends Exception {
        public java_04342_CredentialValidator_A01(String message) {
            super(message);
        }
    }
}