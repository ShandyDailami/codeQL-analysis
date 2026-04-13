import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthException;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;

public class java_03502_CredentialValidator_A01 implements CallbackHandler {

    @Override
    public CredentialValidationResult validate(Callback[] callbacks)
            throws LoginException, UnsupportedCallbackException {

        CredentialValidationResult result = null;

        for (Callback callback : callbacks) {
            String param = callback.getClass().getName();
            if (param.equals("javax.security.auth.usernamePassword")) {
                UsernamePasswordAuthException authException = (UsernamePasswordAuthException) callbacks[0].get();
                result = new CredentialValidationResult(authException.getRequestedOperation(), false);
            }
        }

        if (result == null) {
            throw new UnsupportedCallbackException(callbacks[0], "Unsupported callback");
        }

        return result;
    }
}