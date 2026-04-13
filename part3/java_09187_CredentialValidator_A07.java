import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControlException;
import java.security.auth.Credential;

public class java_09187_CredentialValidator_A07 implements LoginModule {

    private String username;
    private String password;

    @Override
    public void initialize(Subject subject, Credential credential) {
        this.username = credential.getIdentifier();
        this.password = credential.getPassword();
    }

    @Override
    public boolean commit() throws LoginException {
        if ("admin".equals(this.username) && "password".equals(this.password)) {
            return true;
        } else {
            throw new LoginException("Authentication failed");
        }
    }

    @Override
    public void abort(Subject subject, String message) throws LoginException {
        throw new LoginException(message);
    }

    @Override
    public boolean terminate() throws AccessControlException {
        return false;
    }
}