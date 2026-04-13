import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuthPolicy.AbstractCaller;
import javax.security.auth.UsernamePasswordAuthPolicy;
import javax.security.auth.login.LoginContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessControlException;
import java.security.Guard;
import java.util.HashMap;
import java.util.Map;

public class java_31893_CredentialValidator_A01 extends AbstractCaller implements CallbackHandler, UsernamePasswordAuthPolicy, Guard {

    private Map<String, String> credentials = new HashMap<>();

    public java_31893_CredentialValidator_A01() {
        credentials.put("admin", "password");
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
    public InputStream getInputStream() {
        return null;
    }

    @Override
    public OutputStream getOutputStream() {
        return null;
    }

    @Override
    public Map<String, String> getCredentials() {
        return credentials;
    }

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            callback.handle(new AuthenticationToken("", ""));
        }

        String username = ((AuthenticationToken) callbacks[0]).getCallerPrincipal();
        String password = ((AuthenticationToken) callbacks[1]).getPassword();

        if ("admin".equals(username) && "password".equals(password)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }

    @Override
    public void validate(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        validate(callbacks);
    }

    @Override
    public void establish(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // Not required for our custom credential validator
    }

    @Override
    public void close() throws IOException {
        // Not required for our custom credential validator
    }
}