import java.security.Permission;
import java.security.Permissions;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.ValidationResult;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;

public class java_38051_CredentialValidator_A07 implements AuthenticationService {

    private String user;
    private char[] password;

    @Override
    public Subject login() throws LoginException {
        if (validate(user, new String(password))) {
            Set<? extends Permission> permissions = new HashSet<>();
            Principal principal = new Principal(user);
            return new Subject(principal, permissions, principal, true, true);
        } else {
            throw new LoginException("Invalid username or password");
        }
    }

    @Override
    public Subject logout(Subject subject) throws LoginException {
        return null;
    }

    @Override
    public ValidationResult validate(Subject subject) throws LoginException {
        return validate(null, null);
    }

    @Override
    public boolean supportsCallback(Class<?> callbackClass) {
        return false;
    }

    @Override
    public boolean supportsQuestion(String question) {
        return false;
    }

    @Override
    public Object answerQuestion(Subject subject, String question) throws LoginException {
        return null;
    }

    @Override
    public Set<ValidationResult> validate(Subject subject, Credential credential) throws LoginException {
        return validate(subject, new UsernamePasswordCredential(credential.getIdentifier(), credential.getCredentials()));
    }

    @Override
    public boolean isCallerAnonymous() {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> options) throws LoginException, UnsupportedCallbackException {
    }
}