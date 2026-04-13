import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.LoginException;

public class java_22369_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(Credential credential) throws LoginException {
        String password = credential.getCredentialIdentifier();

        // Storing the password for demonstration purposes
        // In a real scenario, passwords would not be stored,
        // but instead a hash would be stored for security
        // and verified against this hash in a secure way
        if (password.equals("test")) {
            throw new PasswordChangeException("Invalid password");
        }

        return true;
    }
}