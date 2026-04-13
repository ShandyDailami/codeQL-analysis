import java.security.GeneralSecurityException;
import java.security.Principal;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;

public class java_10359_CredentialValidator_A07 implements CredentialValidationResult, CredentialValidationResult.Status, CallbackHandler {

    private String userName;
    private String password;
    private boolean authenticated;

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        Callback[] callbacks = new Callback[1];
        callbacks[0] = new UsernamePasswordCallback("User Name:", "Password:");
        callbackHandler.handle(callbacks);
        this.userName = ((UsernamePasswordCallback) callbacks[0]).getPassword();
        this.password = ((UsernamePasswordCallback) callbacks[0]).getPassword();
        // Assuming user has correct credentials (i.e., userName equals password)
        this.authenticated = this.userName.equals(this.password);
        return new StatusResult(this.authenticated ? CredentialValidationResult.SUCCESS : CredentialValidationResult.FAILURE);
    }

    private class UsernamePasswordCallback extends Callback {
        private String prompt;
        private String description;
        private String response;

        public java_10359_CredentialValidator_A07(String prompt, String description) {
            this.prompt = prompt;
            this.description = description;
        }

        @Override
        public String getPrompt() {
            return prompt;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public String getResponse() throws LoginException, UnsupportedCallbackException {
            return response;
        }

        @Override
        public void setResponse(String response) throws UnsupportedCallbackException {
            this.response = response;
        }
    }
}