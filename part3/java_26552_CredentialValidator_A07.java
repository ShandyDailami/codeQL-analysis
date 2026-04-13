import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.security.Principal;
import java.security.AuthPermission;

public class java_26552_CredentialValidator_A07 implements CallbackHandler {
    private Map<String, String> map;

    public java_26552_CredentialValidator_A07() {
        this.map = new HashMap<String, String>();
    }

    @Override
    public void handle(Callback callback) throws IOException, UnsupportedCallbackException {
        map.put("username", "testuser");
        map.put("password", "testpassword");
        callback.done();
    }

    public Subject getSubject(CallbackHandler callbackHandler, Principal arg2) throws AuthenticationException, LoginException {
        return new Subject(new Principal(arg2), Collections.unmodifiableMap(map), new AuthPermission[]{new AuthPermission("act as" + arg2.getName())}, null);
    }
}

public class CredentialValidator {
    private CallbackHandler callbackHandler;
    private Principal principal;

    public java_26552_CredentialValidator_A07(CallbackHandler callbackHandler, Principal principal) {
        this.callbackHandler = callbackHandler;
        this.principal = principal;
    }

    public Subject validate(Subject subject) throws AuthenticationException, LoginException {
        return callbackHandler.getSubject(callbackHandler, principal);
    }
}