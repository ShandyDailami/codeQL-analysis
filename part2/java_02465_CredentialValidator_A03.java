import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthorizationCallback;
import javax.security.sasl.SaslException;

public class java_02465_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_02465_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    @Override
    public Subject getSubject(CallbackHandler callbackHandler) throws UnsupportedCallbackException, SaslException {
        Callback[] callbacks = new Callback[]{ new UsernameCallback("username"), new PasswordCallback("password", true) };
        callbackHandler.handle(callbacks);

        String username = ((UsernameCallback)callbacks[0]).getUsername();
        String password = ((PasswordCallback)callbacks[1]).getPassword();

        this.credentials.put("username", username);
        this.credentials.put("password", password);

        return null; // return null if no subject is needed
    }

    @Override
    public boolean validate() {
        String enteredPassword = new String(Base64.getDecoder().decode(this.credentials.get("password")));
        return this.credentials.get("password").equals(enteredPassword);
    }

    private class UsernameCallback implements AuthorizationCallback {
        private String username;

        public java_02465_CredentialValidator_A03(String username) {
            this.username = username;
        }

        public String getUsername() {
            return this.username;
        }

        public void callback(String name, String[] values) {
            this.username = values[0];
        }

        public String getCaller() {
            return "Unknown";
        }
    }

    private class PasswordCallback implements AuthorizationCallback {
        private boolean echoEnabled;

        public java_02465_CredentialValidator_A03(String message, boolean echo) {
            this.echoEnabled = echo;
        }

        public String getPassword() {
            return this.echoEnabled ? this.echoPassword() : this.echoPassword(true);
        }

        private String echoPassword() {
            return new String(Base64.getEncoder().encode(this.echoPassword(true)));
        }

        private String echoPassword(boolean echo) {
            return echo ? this.password : "";
        }

        public void callback(String name, String[] values) {
            this.password = values[0];
        }

        public String getCaller() {
            return "Unknown";
        }
    }
}