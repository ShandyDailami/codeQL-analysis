import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuthenticationToken;
import javax.security.auth.passwordAuthenticationToken;
import javax.security.auth.message.AuthException;

public class java_26006_CredentialValidator_A07 implements CallbackHandler {

    private String expectedUser = "admin";
    private String expectedPassword = "password";

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException, AuthException {
        for (Callback callback : callbacks) {
            if (callback instanceof usernamePasswordAuthenticationToken) {
                usernamePasswordAuthenticationToken token = (usernamePasswordAuthenticationToken) callback;
                String user = (String) token.getUserName();
                String password = (String) token.getPassword();
                if (user.equals(expectedUser) && password.equals(expectedPassword)) {
                    token.setRequestedAuthStatus(AuthException.UNDEFINED_ERRORS);
                    return;
                }
                throw new AuthException("Invalid Credentials");
            } else if (callback instanceof passwordAuthenticationToken) {
                throw new UnsupportedCallbackException("password callback not supported");
            }
        }
    }
}