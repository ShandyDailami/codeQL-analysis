import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.GuaranteedAccessException;
import java.util.HashMap;
import java.util.Map;

public class java_09536_CredentialValidator_A03 implements CallbackHandler {

    private Map<String, String> credentials = new HashMap<>();

    public java_09536_CredentialValidator_A03() {
        // Add some dummy credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean validate(Subject subject, Callback[] callbacks)
            throws GuaranteedAccessException, LoginException {
        UsernamePasswordCallback callback = (UsernamePasswordCallback) callbacks[0];

        // Check if the credentials are valid
        if (credentials.containsKey(callback.getUsername()) &&
                credentials.get(callback.getUsername()).equals(callback.getPassword())) {
            return true;
        }

        return false;
    }
}