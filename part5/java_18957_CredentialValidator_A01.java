import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_18957_CredentialValidator_A01 implements LoginModule {

    private Set<Principal> principals = new HashSet<>();

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, Object> options) throws LoginException {
        // Do nothing
    }

    @Override
    public boolean validate(Subject subject, Principal user,
                            Object credentials) throws LoginException {
        // Add the user to the set of principals
        principals.add(user);
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        // Do nothing
        return true;
    }

    @Override
    public void cleanup() {
        // Do nothing
    }

    public Set<Principal> getPrincipals() {
        return principals;
    }
}