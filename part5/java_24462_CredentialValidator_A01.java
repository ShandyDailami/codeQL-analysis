import java.security.Credential;
import java.security.InvalidParameterException;

public class java_24462_CredentialValidator_A01 {
    // This method validates a password.
    // It throws an InvalidParameterException if the password is null or empty.
    public void validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }
    }

    // This method validates a username.
    // It throws an InvalidParameterException if the username is null or empty.
    public void validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }
    }

    // This method validates a credential.
    // It throws an InvalidParameterException if the credential is null.
    public void validateCredential(Credential credential) {
        if (credential == null) {
            throw new InvalidParameterException("Credential cannot be null");
        }
    }

    // This is a demonstration of how you might use the CredentialValidator.
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        validator.validateUsername("user");
        validator.validatePassword("password");
        validator.validateCredential(null);
    }
}