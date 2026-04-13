import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_30425_CredentialValidator_A01 implements LoginModule, CallbackHandler {

    private Map<String, String> credentialMap;

    private Subject subject;

    public java_30425_CredentialValidator_A01() {
        credentialMap = new HashMap<>();
        credentialMap.put("user1", "password1");
        credentialMap.put("user2", "password2");
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) {
        this.subject = subject;
    }

    @Override
    public Credential validate(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        // No authentication method is requested, so return null.
        return null;
    }

    @Override
    public Credential getCredential(String userName, String password) throws LoginException {
        if (credentialMap.containsKey(userName) && credentialMap.get(userName).equals(password)) {
            return new MyCredential(userName);
        }
        throw new LoginException("Invalid username or password");
    }

    private class MyCredential implements Credential {

        private String userName;

        public java_30425_CredentialValidator_A01(String userName) {
            this.userName = userName;
        }

        @Override
        public String getCredentialType() {
            return "username";
        }

        @Override
        public String getCallerPrincipal() {
            return userName;
        }

        @Override
        public String getId() {
            return userName;
        }

        @Override
        public String getName() {
            return userName;
        }
    }
}