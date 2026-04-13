import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_36092_CredentialValidator_A03 implements LoginModule {
    private Credential credential;

    @Override
    public void initialize(Attributes attrs) throws LoginException {
        credential = new UsernamePasswordCredential();
        credential.setUsername(attrs.getRequiredAttribute(Credential.USERNAME_ATTRIBUTE));
        credential.setPassword(attrs.getRequiredAttribute(Credential.PASSWORD_ATTRIBUTE).toString());
    }

    @Override
    public Credential validate(Credential cred) throws LoginException {
        if (cred.getUsername().equals(credential.getUsername()) &&
                cred.getPassword().equals(credential.getPassword())) {
            return credential;
        } else {
            throw new LoginException("Authentication failed");
        }
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void cleanup() {
    }
}