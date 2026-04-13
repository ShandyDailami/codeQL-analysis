import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.security.Guard;
import java.util.Arrays;

public class java_10849_CredentialValidator_A08 implements CredentialValidationResult, CredentialHandler, CallbackHandler {

    private String password;

    public java_10849_CredentialValidator_A08(String password) {
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) {
        return validatePassword(Arrays.asList(callbacks));
    }

    private CredentialValidationResult validatePassword(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        return validatePassword(Arrays.asList(callbackHandler));
    }

    private CredentialValidationResult validatePassword(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        return validatePassword(callbackHandler.getCallbacks());
    }

    private CredentialValidationResult validatePassword(Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
        final CallbackHandler callbackHandler = new CallbackHandler() {
            public CredentialValidationResult validate(Callback[] callbacks) throws LoginException, UnsupportedCallbackException {
                return doValidate(Arrays.asList(callbacks));
            }
        };
        return validatePassword(callbackHandler);
    }

    private CredentialValidationResult validatePassword(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        final Guard guard = new Guard();
        guard.validate(password);
        return new CredentialValidationResult("Validated", "Access granted", guard.getAttributes());
    }
}