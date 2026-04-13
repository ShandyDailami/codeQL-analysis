import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidator;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_03834_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> credentials = new HashMap<>();

    public java_03834_CredentialValidator_A03() {
        credentials.put("username", "password");
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean validate(Subject subject, String callerPrincipal,
            String password) {
        return credentials.get(callerPrincipal).equals(password);
    }

    @Override
    public void initialize(CallbackHandler callbackHandler,
            Subject subject) {
        // not used
    }
}