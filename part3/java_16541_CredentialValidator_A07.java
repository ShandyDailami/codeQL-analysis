import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class java_16541_CredentialValidator_A07 implements LoginModule {

    private Map<String, String> users = new HashMap<>();

    public java_16541_CredentialValidator_A07() {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) throws LoginException {
        // Not used in this example
    }

    @Override
    public boolean validate(Subject subject, String callerPrincipal, Object password) throws LoginException {
        String presentedPassword = password.toString();
        if (users.containsKey(callerPrincipal) && users.get(callerPrincipal).equals(presentedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean commit() throws LoginException {
        // Not used in this example
        return true;
    }

    @Override
    public void cleanup() {}
}