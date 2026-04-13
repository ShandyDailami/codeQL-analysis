import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_26133_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> mockDatabase = new HashMap<>();

    public java_26133_CredentialValidator_A03() {
        mockDatabase.put("user1", "password1");
        mockDatabase.put("user2", "password2");
    }

    @Override
    public void validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        if (!mockDatabase.containsKey(username) || !mockDatabase.get(username).equals(password)) {
            throw new CredentialException("Invalid credentials");
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new MockCallbackHandler();
    }
}

class MockCallbackHandler implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws CredentialException, IOException, UnsupportedCallbackException {
        // Do nothing, we do not actually handle callbacks
    }
}