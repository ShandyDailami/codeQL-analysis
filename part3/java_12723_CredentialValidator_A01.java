import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

public class java_12723_CredentialValidator_A01 implements CredentialValidator {

    private Credential currentCredential;

    @Override
    public void validate(Credential credential) throws LoginException {
        this.currentCredential = credential;
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public Credential getCredential() {
        return this.currentCredential;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new MyCallbackHandler();
    }

    private class MyCallbackHandler implements CallbackHandler {

        @Override
        public Credential getCredential(String arg0, String arg1) throws LoginException, UnsupportedCallbackException {
            return currentCredential;
        }

        @Override
        public void validate(Credential arg0) throws LoginException, UnsupportedCallbackException {
            // Doesn't need to do anything because we already have the credential
        }
    }
}