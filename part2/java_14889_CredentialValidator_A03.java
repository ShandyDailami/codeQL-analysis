import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.username.UsernamePasswordCallback;
import javax.security.auth.login.LoginException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_14889_CredentialValidator_A03 implements CallbackHandler {

    private Map<String, String> credentials = new HashMap<>();

    public java_14889_CredentialValidator_A03() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, LoginException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];

        String id = callback.getID();

        if (credentials.containsKey(id)) {
            String password = credentials.get(id);
            callback.setPassword(password.toCharArray());
        } else {
            throw new LoginException("Unknown user");
        }
    }
}

public class MySubject extends Subject {

    private MyCallbackHandler callbackHandler;

    public java_14889_CredentialValidator_A03(MyCallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public void authenticate(String userName, String password) throws LoginException {
        // No-op
    }

    @Override
    public boolean containsUser(String userName) {
        return true;
    }

    @Override
    public Subject getParent() {
        return null;
    }

    @Override
    public boolean hasRole(String role) {
        return false;
    }

    @Override
    public boolean runAs(String user) throws LoginException {
        return true;
    }

    @Override
    public boolean login() throws LoginException {
        return false;
    }

    @Override
    public void logout() throws LoginException {
        // No-op
    }

    @Override
    public String getCallerPrincipal() {
        return "user1";
    }
}

public class MyAuthenticator implements javax.security.auth.spi.Authenticator {

    @Override
    public Subject authenticate(Subject subject, String[] userName, String[] password) throws LoginException, NotAuthorizedException {
        return new MySubject(new MyCallbackHandler());
    }
}