import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.Principal;
import java.security.auth.AuthException;
import java.util.HashMap;
import java.util.Map;

public class java_28312_CredentialValidator_A01 implements LoginModule {

    private Map<String, String> userDB = new HashMap<>();

    public java_28312_CredentialValidator_A01() {
        userDB.put("alice", "password");
        userDB.put("bob", "password");
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) throws AuthException, LoginException {
        // No action necessary here
    }

    @Override
    public boolean validate(Subject subject, String username, String password) throws AuthException {
        return userDB.containsKey(username) && userDB.get(username).equals(password);
    }

    @Override
    public boolean commit() throws AuthException, LoginException {
        return true;
    }

    @Override
    public boolean abort() throws LoginException, AuthException {
        return false;
    }

    @Override
    public boolean supportsStaticCallbackHandler() {
        return false;
    }

    @Override
    public boolean supportsCallbackHandler(CallbackHandler callbackHandler) {
        return false;
    }
}