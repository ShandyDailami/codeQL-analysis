import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;

public class java_09529_CredentialValidator_A07 implements CallbackHandler {

    @Override
    public CredentialHandler getHandler() {
        return new CustomCredentialHandler();
    }

    private static class CustomCredentialHandler implements CredentialHandler {

        private String password;

        @Override
        public CredentialValidationResult validate(Callback[] callbacks) throws CredentialException, UnsupportedCallbackException {
            for (Callback callback : callbacks) {
                if (callback instanceof PasswordCallback) {
                    PasswordCallback passwordCallback = (PasswordCallback) callback;
                    password = passwordCallback.getPassword();
                    return new CredentialValidationResult(password.matches("correct_password"), "");
                }
           
            }
            return new CredentialValidationResult("false", "");
        }
    }

    private static class PasswordCallback implements Callback {

        private String password;

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public void completed(String password) throws CredentialException {
            setPassword(password);
        }

        @Override
        public void incomplete(String message) {
            // do nothing
        }

        @Override
        public boolean handle(Callback callback) throws UnsupportedCallbackException {
            throw new UnsupportedCallbackException(callback, "Unknown Callback");
        }
    }
}