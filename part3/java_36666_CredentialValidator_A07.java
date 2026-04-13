import java.security.AuthenticationException;
import java.util.Arrays;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_36666_CredentialValidator_A07 implements LoginModule {

    private String username;
    private char[] password;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, ?> options) throws LoginException, UnsupportedCallbackException {

        // Get username and password from callbackHandler
        Callback[] callbacks = callbackHandler.getCallbacks();
        for (Callback callback : callbacks) {
            if (callback instanceof UsernamePasswordCallback) {
                UsernamePasswordCallback callback2 = (UsernamePasswordCallback) callback;
                this.username = callback2.getIdentifier();
                this.password = callback2.getPassword();
            }
        }
    }

    @Override
    public boolean validate() throws AuthenticationException {
        // Verify username and password against hard-coded list
        return Arrays.equals(username.toCharArray(), this.password);
    }
}