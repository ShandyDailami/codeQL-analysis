import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class java_19610_CredentialValidator_A08 implements CallbackHandler {

    @Override
    public Credential validationResult(Subject subject) throws LoginException {
        return null;
    }

    @Override
    public Credential getCredential(Subject subject, String authenticationSpec, Object attributes) throws LoginException, UnsupportedCallbackException {
        return null;
    }

}

public class MyCredentialValidator implements javax.security.auth.CredentialValidator {

    @Override
    public Credential validate(Credential c) throws LoginException {
        return null;
    }

    @Override
    public Credential validate(CallbackHandler callbackHandler, Credential c) throws LoginException, UnsupportedCallbackException {
        return null;
    }

}