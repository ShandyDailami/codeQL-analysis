import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControlException;
import java.security.AuthenticationException;
import java.security.GuaranteedAccessException;
import java.util.HashMap;
import java.util.Map;

public class java_14309_CredentialValidator_A03 implements javax.security.auth.credential.CredentialValidator {

    private Map<String, String> credentials = new HashMap<>();

    public java_14309_CredentialValidator_A03() {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    @Override
    public Subject getSubject(CallbackHandler callbackHandler, Callback[] callbacks) throws AuthenticationException, AccessControlException {
        return null;
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler, Callback[] callbacks) throws AuthenticationException, AccessControlException {
        String userName = callbacks[0].getAttribute("login.username").toString();
        String password = callbacks[0].getAttribute("login.password").toString();

        return credentials.containsKey(userName) && credentials.get(userName).equals(password);
    }
}