import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class java_09266_CredentialValidator_A03 implements LoginModule {

    private String username;
    private char[] password;
    private Subject subject;
    private Map<String, Principal> principals = new HashMap<>();
    private Map<String, Object> credentials = new HashMap<>();

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) throws LoginException, UnsupportedCallbackException {
        this.subject = subject;
        Callback[] callbacks = callbackHandler.getCallbacks();
        for (Callback callback : callbacks) {
            callbackHandler.handle(callback);
        }
    }

    @Override
    public boolean validate(CharSequence charSequence) throws LoginException {
        password = charSequence.toString().toCharArray();
        if (!isPasswordValid()) {
            throw new LoginException("Invalid password");
        }
        return true;
    }

    private boolean isPasswordValid() {
        if (password == null) {
            return false;
        }
        if (password.length == 0) {
            return false;
        }
        if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$", password)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        if (username != null && password != null) {
            principals.put(username, new Principal(username));
            credentials.put("password", new String(password));
            subject.getPrincipals().add(new Principal("password"));
        }
        return true;
    }

    @Override
    public void abort(Subject subject, String action, Exception exception) throws LoginException, UnsupportedCallbackException {
        throw new UnsupportedOperationException();
    }
}