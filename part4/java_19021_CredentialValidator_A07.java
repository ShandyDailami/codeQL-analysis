import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControlException;
import java.security.Guard;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_19021_CredentialValidator_A07 implements LoginModule {

    private Set<String> users = new HashSet<>();

    public java_19021_CredentialValidator_A07() {
        users.add("user1");
        users.add("user2");
    }

    @Override
    public boolean validate(Subject subject, Object credentials, CallbackHandler callbackHandler)
            throws LoginException, AccessControlException {

        String user = credentials.toString();
        return users.contains(user);
    }

    @Override
    public boolean commit() throws LoginException, AccessControlException {
        return true;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Principal principal) throws LoginException, AccessControlException {
        // Not needed in our case
    }

    @Override
    public boolean supportsStoredCredentials() {
        return false;
    }
}