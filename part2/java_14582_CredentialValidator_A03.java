import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_14582_CredentialValidator_A03 implements CallbackHandler {

    private Map<String, String> credentials = new HashMap<>();

    public java_14582_CredentialValidator_A03() {
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public String getPassword(String arg0) throws UnsupportedCallbackException {
        String password = credentials.get(arg0);
        if (password == null) {
            throw new UnsupportedCallbackException("Password not available for the given username");
        }
        return password;
    }

    @Override
    public void initialize(String arg0, Map<String, String> arg1) throws UnsupportedCallbackException {
        throw new UnsupportedCallbackException("This method should not be called");
    }
}

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class CustomLoginModule implements LoginModule {

    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) throws IOException, UnavailableException {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean login() throws LoginException {
        subject.authenticate(new Callback[]{new CustomCallbackHandler()});
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        throw new LoginException("commit() method should not be called");
    }

    @Override
    public boolean logout() throws LoginException {
        throw new LoginException("logout() method should not be called");
    }
}

import javax.security.auth.Subject;
import javax.security.auth.authenticator.Authenticator;
import javax.security.auth.authenticator.AuthenticatorCallback;
import javax.security.auth.login.LoginException;

public class CustomAuthenticator implements Authenticator {

    @Override
    public Subject authenticate(Subject subject, String arg1, Object arg2, AuthenticatorCallback callback) throws LoginException {
        callback.setAuthenticated(false);
        return subject;
    }
}