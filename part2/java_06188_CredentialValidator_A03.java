import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_06188_CredentialValidator_A03 implements CredentialValidationResult, CallbackHandler {
    private Map<String, String> credentials = new HashMap<>();

    public java_06188_CredentialValidator_A03(String[] usernames, String[] passwords) {
        for (int i = 0; i < usernames.length; i++) {
            credentials.put(usernames[i], passwords[i]);
        }
    }

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) {
        return validate(callbacks);
    }

    @Override
    public CredentialValidationResult validate(Callback callback) {
        if (callback instanceof UsernamePasswordCallback) {
            UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;
            String username = callbackObj.getIdentifier();
            String password = callbackObj.getPassword();
            String expectedPassword = credentials.get(username);

            if (expectedPassword != null && expectedPassword.equals(password)) {
                return new CredentialValidationResult("Success", "Custom Credential Validator");
            } else {
                return new CredentialValidationResult("Failure", "Custom Credential Validator");
            }
        }
        return null;
    }

    public static class UsernamePasswordCallback implements Callback {
        private String identifier;
        private String password;

        @Override
        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        @Override
        public String getIdentifier() {
            return identifier;
        }

        @Override
        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }
}