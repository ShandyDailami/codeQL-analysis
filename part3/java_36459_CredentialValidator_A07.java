import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_36459_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws LoginException {
        // For simplicity, we're only checking if the user provided a password
        if (credential.getIdentifier().equals("user") && credential.getPassword().equals("password")) {
            return true;
        } else {
            throw new LoginException("Invalid credentials");
        }
    }
}