import java.util.Base64;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_39601_CredentialValidator_A07 implements CredentialValidator {
    private Map<String, String> credentials;

    public java_39601_CredentialValidator_A07() {
        credentials = new HashMap<>();
    }

    public void addCredentials(String domain, String credentials) {
        credentials.put(domain, credentials);
    }

    @Override
    public Subject validate(Subject subject) throws LoginException {
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return "Authenticated User";
            }
        };

        subject.getPrincipals().add(principal);
        return subject;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public Callback[] getCallbacks() {
                return new Callback[0];
            }

            @Override
            public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
                // Do nothing
            }
        };
    }
}