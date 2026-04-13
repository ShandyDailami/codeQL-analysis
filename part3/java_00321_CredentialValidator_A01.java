import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredentials;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_00321_CredentialValidator_A01 implements LoginModule {

    private UsernamePasswordCredentials credentials;

    @Override
    public void initialize(String needsAttribute, javax.security.auth.Attributes attributes) {
        // Retrieve the credentials
        credentials = (UsernamePasswordCredentials) attributes.get(UsernamePasswordCredentials.class.getSimpleName());
        if (credentials == null) {
            throw new CredentialException("No credentials found");
        }
    }

    @Override
    public boolean authenticate() throws CredentialException {
        // Assume the credentials are valid if the user name matches "admin" and password is "password"
        return "admin".equals(credentials.getIdentifier()) && "password".equals(credentials.getPassword());
    }

    @Override
    public boolean commit() throws CredentialException {
        return authenticate();
    }

    @Override
    public void cleanup() {
        // No cleanup required
    }
}