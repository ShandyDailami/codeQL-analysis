import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_31898_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_31898_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler, Map<String, Object> map) throws IOException, UnsupportedCallbackException {
        Credential credential = new Credential();

        Callback[] callbacks = new Callback[1];
        callbacks[0] = new UsernamePasswordCallback("User Name:", "Password:", false, false, false);

        callbackHandler.handle(callbacks);

        String user = callbacks[0].getIdentifier();
        String password = callbacks[0].getPassword();

        if (credentials.get(user) != null && credentials.get(user).equals(password)) {
            credential.setCredential(password);
            return true;
        }

        return false;
    }
}