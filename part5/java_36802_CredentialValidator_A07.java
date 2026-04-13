import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControlException;
import java.security.auth.AuthException;
import java.util.Iterator;
import java.util.Map;

public class java_36802_CredentialValidator_A07 implements LoginModule {
    private Subject subject;
    private boolean loginSuccessful;

    @Override
    public void initialize(Subject subject, Map<String, ?> additionalAuthenticationData, String callingProcess) throws AuthException, AccessControlException {
        this.subject = subject;
        this.loginSuccessful = false;
    }

    @Override
    public boolean authenticate(String userName, String password) throws AuthException {
        if (userName.equals("admin") && password.equals("password")) {
            loginSuccessful = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean commit() throws AuthException, AccessControlException {
        if (!loginSuccessful) {
            throw new AuthException("Authentication failed.");
        }
        return loginSuccessful;
    }

    @Override
    public boolean abort() throws AuthException, AccessControlException {
        return false;
    }

    @Override
    public Iterator<String> getCallingProcessGroups() throws AuthException, AccessControlException {
        return null;
    }

    @Override
    public Iterator<String> getRequiredProviders() throws AuthException, AccessControlException {
        return null;
    }
}