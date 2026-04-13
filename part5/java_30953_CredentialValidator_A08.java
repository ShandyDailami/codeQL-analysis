import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_30953_CredentialValidator_A08 implements CallbackHandler {
    private final List<Callback> callbacks = new ArrayList<>();

    @Override
    public void handle(Callback callback) throws IOException, UnsupportedCallbackException {
        callbacks.add(callback);
        callback.handle(callbacks.toArray(new Callback[0]));
    }
}

public class CustomSubject extends Subject {
    private final List<AuthenticatedSubject> subjects = new ArrayList<>();

    @Override
    public AuthenticatedSubject getSubject(AuthenticationToken arg0) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public AuthenticatedSubject getSubject(AuthenticationToken arg0, List<CallbackHandler> arg1) throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedCallbackException {
        throw new UnsupportedOperationException();
    }
}

public class CredentialValidator implements javax.security.auth.credential.Credential {
    private String password;
    private String username;

    @Override
    public String getCallerPrincipal() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<String> getGroups() throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getAttributes() throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        return username;
    }

    public void validate(String user, String password) throws LoginException {
        if (this.username == null || this.password == null) {
            throw new LoginException("Authentication Failed: Unknown User");
        }

        if (!this.username.equals(user) || !this.password.equals(password)) {
            throw new LoginException("Authentication Failed: Bad Credentials");
        }
    }
}