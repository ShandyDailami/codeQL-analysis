import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AuthenticationException;
import java.security.GuaranteedAccessException;
import java.util.Arrays;

public class java_11954_CredentialValidator_A08 implements CredentialValidator {

    private static final String[] USER_ROLES = new String[]{"USER", "ADMIN"};

    @Override
    public boolean validate(CallbackHandler callbackHandler, Object credentials) throws IOException,
            UnsupportedCallbackException, AccessControlException {

        Callback[] callbacks = new Callback[1];
        callbackHandler.getCallbacks(callbacks);

        UsernamePasswordCallback usernamePasswordCallback = (UsernamePasswordCallback) callbacks[0];

        String userName = usernamePasswordCallback.getIdentifier();
        String password = new String(usernamePasswordCallback.getPassword());

        // Validate credentials here. For example:
        if ("admin".equals(userName) && "password".equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getRequestedAuthenticationKinds() throws IOException, UnsupportedCallbackException, AccessControlException {
        return true;
    }
}

public class UsernamePasswordCallback implements Callback {

    private String identifier;
    private char[] password;

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public java_11954_CredentialValidator_A08(String identifier) throws IOException, UnsupportedCallbackException {
        this.identifier = identifier;
    }

    @Override
    public char[] getPassword() throws IOException, UnsupportedCallbackException {
        return password;
    }
}