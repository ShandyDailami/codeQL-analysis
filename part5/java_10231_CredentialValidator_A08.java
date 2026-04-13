import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.CredentialException;

public class java_10231_CredentialValidator_A08 implements CallbackHandler {

    private Map<String, String> credentials = new HashMap<>();

    public java_10231_CredentialValidator_A08() {
        // You could use a database or a file to store the credentials
        // This example assumes that the credentials are "username:password"
        credentials.put("alice", "password123");
        credentials.put("bob", "123password");
    }

    @Override
    public boolean validate(Subject subject, String caller, CCallback callback) throws CredentialException, CredentialException, UnsupportedCallbackException {
        String username = callback.getIdentifier();
        String password = new String(callback.getPassword(), callback.getIdentifier());

        String expectedPassword = credentials.get(username);

        if (expectedPassword == null || !expectedPassword.equals(password)) {
            throw new CredentialException("Invalid credentials for user " + username);
        }

        return true;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }
}