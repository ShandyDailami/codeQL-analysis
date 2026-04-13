import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_09900_CredentialValidator_A08 implements javax.security.auth.login.LoginModule {

    private Credential credential;
    private Subject subject;
    private CallbackHandler callbackHandler;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) throws LoginException, UnsupportedCallbackException {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }

    @Override
    public Credential getCredential(String arg0) throws LoginException {
        if (credential == null) {
            credential = new MyUsernamePasswordCredential();
        }
        return credential;
    }

    @Override
    public boolean commit(String arg0) throws LoginException, UnsupportedCallbackException {
        if (callbackHandler != null) {
            callbackHandler.handle(new Callback[]{new UsernamePasswordCallback("", "")}, false);
        }
        return true;
    }

    @Override
    public boolean logout() throws LoginException, UnsupportedCallbackException {
        return true;
    }

    private class MyUsernamePasswordCredential implements Credential {

        @Override
        public String getCredential() throws LoginException {
            return "myUserName";
        }

        @Override
        public void setCredential(String arg0) throws LoginException {
            // Do nothing
        }

        @Override
        public boolean validate(Subject subject, Object credentials) throws LoginException {
            return ((String) credentials).equals("myUserName");
        }
    }

    private class UsernamePasswordCallback implements Callback {

        private String prompt;
        private String message;

        public java_09900_CredentialValidator_A08(String prompt, String message) {
            this.prompt = prompt;
            this.message = message;
        }

        @Override
        public void setCallback(CallbackHandler callbackHandler) {
            // Do nothing
        }

        @Override
        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        @Override
        public String getPrompt() {
            return prompt;
        }

        @Override
        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public void validate(Subject subject) throws LoginException {
            // Do nothing
        }

        @Override
        public boolean commit() throws LoginException {
            return true;
        }

        @Override
        public void setClientHelper(CallbackHandler callbackHandler) {
            // Do nothing
        }
    }
}