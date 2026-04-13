import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_39133_CredentialValidator_A07 implements javax.security.auth.login.CredentialValidator {

    private Map<String, String> users = new HashMap<>();

    public java_39133_CredentialValidator_A07() {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    @Override
    public Subject validate(Subject subject, Credential credential) throws LoginException {
        String user = credential.getIdentifier();
        String password = credential.getPassword();

        if (users.containsKey(user) && users.get(user).equals(password)) {
            return subject;
        } else {
            throw new LoginException("Invalid username or password");
        }
    }

    @Override
    public boolean validate(Subject subject, Object credentials, CallbackHandler callbackHandler) throws LoginException {
        throw new UnsupportedCallbackException(callbackHandler.createUnsupportedCallbackException("validate() is not supported"));
    }

    @Override
    public boolean getRequirement(String requirement) throws LoginException {
        throw new UnsupportedCallbackException("getRequirement() is not supported");
    }
}