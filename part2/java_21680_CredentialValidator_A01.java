import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_21680_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws LoginException {
        // Hard-coded values
        String username = "testUser";
        String password = "testPassword";

        // Validate the credentials
        return (credential.getUsername().equals(username) && credential.getPassword().equals(password));
    }

    @Override
    public void initialize(String arg0) throws LoginException {
        // No initialization necessary
    }

    @Override
    public boolean getAcceptedDomain(String arg0) {
        // No accepted domain necessary
        return false;
    }

}