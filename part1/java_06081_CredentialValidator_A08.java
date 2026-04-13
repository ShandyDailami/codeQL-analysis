import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.security.Permission;
import javax.security.auth.Subject.PubliclyPermittedSubject;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_06081_CredentialValidator_A08 implements CallbackHandler {

    private Credential credential;

    public java_06081_CredentialValidator_A08() {
        Properties props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        credential = new MyCredential(props.getProperty("username"), props.getProperty("password"));
    }

    @Override
    public Credential getCredential(CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        return credential;
    }

    private class MyCredential implements Credential {

        private String userName;
        private String password;

        public java_06081_CredentialValidator_A08(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        @Override
        public String getName() {
            return userName;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public boolean validate(Subject subject, Object credentials) throws LoginException {
            String providedPassword = ((MyCredential) credentials).getPassword();
            return password.equals(providedPassword);
        }

        @Override
        public Permission getPermissions() {
            return null;
        }

        @Override
        public PubliclyPermittedSubject getPubliclyPermittedSubject(Subject subject) {
            return null;
        }

        @Override
        public boolean implies(Subject subject, Object permission) {
            return false;
        }

        @Override
        public void refresh() {
        }
    }
}