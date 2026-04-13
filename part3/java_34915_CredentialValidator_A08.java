import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;
import java.security.AuthPermission;
import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

public class java_34915_CredentialValidator_A08 implements CredentialValidator {
    @Override
    public Set<? extends Permission> getPermissions(Subject subject) {
        return new HashSet<>();
    }

    @Override
    public Set<? extends X500Principal> getRoles(Subject subject) {
        return new HashSet<>();
    }

    @Override
    public Credential validate(Subject subject, Credential credential) {
        String password = credential.getCredentialIdentifier();
        if ("password".equals(password)) {
            return credential;
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    @Override
    public void refresh(Subject subject, Credential credential) {
        // This method is not used in this example
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException {
        // This method is not used in this example
    }
}