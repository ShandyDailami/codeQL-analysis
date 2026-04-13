import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuth.realm.Realm;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class java_41295_CredentialValidator_A01 implements CallbackHandler {
    private String user = null;
    private char[] password = null;

    public java_41295_CredentialValidator_A01() {
    }

    public java_41295_CredentialValidator_A01(String user, char[] password) {
        this.user = user;
        this.password = password;
    }

    public Subject authenticate(Subject subject, CallbackHandler callbackHandler, Realm realm, String user,
                                String password) throws IOException, UnsupportedCallbackException {
        callbackHandler.handle(new Callback[]{new UsernamePasswordCallback(user, password)});
        return subject;
    }

    private class UsernamePasswordCallback implements UsernamePasswordCallback {
        private String userNameToAuthenticate;
        private String passwordToAuthenticate;

        public java_41295_CredentialValidator_A01(String userNameToAuthenticate, String passwordToAuthenticate) {
            this.userNameToAuthenticate = userNameToAuthenticate;
            this.passwordToAuthenticate = passwordToAuthenticate;
        }

        public String getUsername() {
            return userNameToAuthenticate;
        }

        public String getPassword() {
            return passwordToAuthenticate;
        }

        public boolean getPassword(char[] chars) {
            return false;
        }
    }
}