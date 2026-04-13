import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class java_32948_CredentialValidator_A07 implements CredentialValidator {
    private CallbackHandler callbackHandler;
    private Map<String, String> properties;

    public java_32948_CredentialValidator_A07(CallbackHandler callbackHandler, Map<String, String> properties) {
        this.callbackHandler = callbackHandler;
        this.properties = properties;
    }

    public boolean validate(Subject subject, Object credentials) throws IOException, LoginException {
        // Unique security-sensitive operation
        // This operation should not be called by the public, as it could lead to a fail-over.
        // For this example, let's say that the operation fails if 'fail' is in the properties.

        String[] p = new String[properties.size()];
        Iterator<String> iter = properties.keySet().iterator();
        int i = 0;
        while (iter.hasNext()) {
            p[i] = iter.next();
            i++;
        }

        if (p.length == 0) {
            return false;
        }

        for (int j = 0; j < p.length; j++) {
            if ("fail".equals(p[j])) {
                return false;
            }
        }

        return true;
    }

    public CallbackHandler getCallbackHandler() throws LoginException {
        return callbackHandler;
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}