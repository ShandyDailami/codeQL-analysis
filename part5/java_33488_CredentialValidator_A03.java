import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordCredential;

public class java_33488_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(Subject subject, UsernamePasswordCredential credential) throws LoginException, InvalidCredentialException {
        // Check if username matches pattern
        if (credential.getUsername().matches("^[A-Za-z0-9]*$")) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username");
        }
    }
}