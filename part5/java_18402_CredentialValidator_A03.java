import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_18402_CredentialValidator_A03 implements CredentialValidator {
    private Map<String, String> credentials;

    public java_18402_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("username", "admin");
        this.credentials.put("password", "password");
    }

    @Override
    public String getName() {
        return "CustomCredentialValidator";
    }

    @Override
    public boolean validate(Subject subject, Object credentials, CallbackHandler callbackHandler) throws AuthenticationException {
        if (credentials == null) {
            return false;
        }

        Callback[] callbacks = new Callback[1];
        try {
            callbacks[0] = new CredentialIDCallback();
            callbackHandler.getCallbacks(callbacks);

            String suppliedUsername = ((CredentialIDCallback) callbacks[0]).getIdentifier();

            if (!this.credentials.containsKey(suppliedUsername)) {
                throw new AuthenticationException("Invalid username or password");
            }

            String suppliedPassword = new String(this.credentials.get(suppliedUsername).getBytes(), "UTF-8");

            if (!this.credentials.get(suppliedUsername).equals(suppliedPassword)) {
                throw new AuthenticationException("Invalid username or password");
            }
        } catch (UnsupportedCallbackException | IOException e) {
            throw new AuthenticationException("Authentication failed");
        }

        return true;
    }

    private class CredentialIDCallback implements Callback {
        private String identifier;

        @Override
        public void setCallbackType(String callbackType) {
        }

        @Override
        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getIdentifier() {
            return this.identifier;
        }
    }
}