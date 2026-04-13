import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_12063_CredentialValidator_A03 implements CallbackHandler {
    private Map<String, String> storedCredentials = new HashMap<>();

    @Override
    public Credential getCredential(String s, String s1, String s2, String s3) throws LoginException, IOException, UnsupportedCallbackException {
        return new CustomCredential(s1, s2);
    }

    private class CustomCredential implements Credential {
        private String username;
        private String password;

        public java_12063_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String getChallenge() {
            return "Custom Credential";
        }

        @Override
        public void clearCredentials() {
            this.username = null;
            this.password = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CustomCredential that = (CustomCredential) o;

            if (username != null ? !username.equals(that.username) : that.username != null) return false;
            return password != null ? password.equals(that.password) : that.password == null;
        }

        @Override
        public int hashCode() {
            int result = username != null ? username.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }
    }
}