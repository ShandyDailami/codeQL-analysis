import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_31463_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_31463_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public Subject getSubject(CallbackHandler callbackHandler, Map<String, Object> map) throws IOException, AuthenticationException {
        Callback[] callbacks = new Callback[]{new UsernamePasswordCallback("user", "password")};
        callbackHandler.handle(callbacks);

        if (callbacks[0].getRequest().equals("user") &&
                callbacks[0].getResponse().equals(credentials.get(callbacks[0].getRequest()))) {
            return new LegacySubject(callbacks[0].getRequest());
        }
        return null;
    }

    private static class LegacySubject implements Subject {

        private String userName;

        public java_31463_CredentialValidator_A01(String userName) {
            this.userName = userName;
        }

        @Override
        public String getName() {
            return userName;
        }

        @Override
        public String getPrincipalName() {
            return userName;
        }

        @Override
        public void setPrincipal(String arg0) {
            // Not implemented
        }

        @Override
        public String getSID() {
            // Not implemented
            return null;
        }

        @Override
        public void setSID(String arg0) {
            // Not implemented
        }

        @Override
        public void removeSID(String arg0) {
            // Not implemented
        }

        @Override
        public Map<String, Object> getAttributes() {
            // Not implemented
            return null;
        }

        @Override
        public void setAttribute(String arg0, Object arg1) {
            // Not implemented
        }

        @Override
        public void removeAttribute(String arg0) {
            // Not implemented
        }

        @Override
        public boolean hasAttribute(String arg0) {
            // Not implemented
            return false;
        }

        @Override
        public void login() throws AuthenticationException {
            // Not implemented
        }

        @Override
        public void logout() throws AuthenticationException {
            // Not implemented
        }
    }

    private static class UsernamePasswordCallback implements Callback {

        private String request;
        private String response;

        public java_31463_CredentialValidator_A01(String request, String response) {
            this.request = request;
            this.response = response;
        }

        @Override
        public String getRequest() {
            return request;
        }

        @Override
        public String getResponse() {
            return response;
        }

        @Override
        public void setRequest(String arg0) {
            // Not implemented
        }

        @Override
        public void setResponse(String arg0) {
            // Not implemented
        }
    }
}