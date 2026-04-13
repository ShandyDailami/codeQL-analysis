import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class java_20840_CredentialValidator_A08 implements CallbackHandler {
    private Map<String, String> credentials;

    public java_20840_CredentialValidator_A08(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    @Override
    public Map<String, String> getCallerPrincipal() {
        return this.credentials;
    }

    @Override
    public Set<String> getSupportedCallbacks() {
        return this.credentials.keySet();
    }

    @Override
    public void handle(Callback callback) throws IOException, UnsupportedCallbackException {
        String key = callback.getRequest().getRequestedPrivilege();
        if (this.credentials.containsKey(key)) {
            callback.setCallbackResult(this.credentials.get(key));
        } else {
            throw new UnsupportedCallbackException();
        }
    }

    public static void main(String[] args) throws LoginException {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", "admin");
        credentials.put("password", "password");

        CredentialValidator validator = new CredentialValidator(credentials);
        Subject.login(validator);
    }
}