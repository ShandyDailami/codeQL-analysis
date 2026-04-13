import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_03446_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) throws LoginException {
        // Validate username and password
        if (credential.getIdentifier() == null || credential.getPassword() == null) {
            throw new LoginException("Username or password cannot be null");
        }
        if (credential.getIdentifier().length() <= 7 || credential.getPassword().length() <= 7) {
            throw new LoginException("Username and password must be at least 8 characters long");
        }

        // If validation is successful, return the credential
        return credential;
    }
}