import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_01318_CredentialValidator_A01 implements LoginModule {

    private String username;
    private String password;
    private boolean authenticated = false;

    @Override
    public void initialize(AuthenticationService authenticationService, String s) throws LoginException {
        // This method is not used in this example
    }

    @Override
    public Credential requestCredential(String s, String s1, String s2, String s3) throws LoginException, UnsupportedCallbackException {
        // This method handles user name and password input
        CallbackHandler handler = new CallbackHandler() {
            @Override
            public Credential getCredential(String s, String s1, String s2, String s3) throws LoginException, UnsupportedCallbackException {
                if (s.equals(username) && s1.equals(password)) {
                    return new UsernamePasswordCredential(username, password);
                } else {
                    throw new LoginException("Authentication failed.");
                }
            }
        };

        UsernamePasswordCallback callback = new UsernamePasswordCallback("", false);
        handler.handle(callback);

        if (callback.getStatus() == 0) {
            throw new LoginException("Authentication failed.");
        }

        return null;
    }

    @Override
    public boolean commit(String s) throws LoginException {
        // This method handles user name input
        CallbackHandler handler = new CallbackHandler() {
            @Override
            public Credential getCredential(String s, String s1, String s2, String s3) throws LoginException, UnsupportedCallbackException {
                return new UsernamePasswordCredential(username, password);
            }
        };

        UsernamePasswordCallback callback = new UsernamePasswordCallback(s, false);
        handler.handle(callback);

        if (callback.getStatus() == 0) {
            throw new LoginException("Authentication failed.");
        }

        authenticated = true;
        return authenticated;
    }

    @Override
    public boolean abort(String s) throws LoginException {
        // This method is not used in this example
        return false;
    }

    @Override
    public boolean logout(String s) throws LoginException {
        // This method is not used in this example
        return false;
    }

    public static class UsernamePasswordCallback extends javax.security.auth.login.LoginCallback {

        public java_01318_CredentialValidator_A01(String prompt, boolean echo) {
            super(prompt, echo);
        }

        public boolean getRequestedCredential(String prompt, String &answer, String challenge, String authreq) throws LoginException, UnsupportedCallbackException {
            return false;
        }

        public boolean getSelectedCredential(String prompt, String &answer, String challenge, String authreq) throws LoginException, UnsupportedCallbackException {
            return false;
        }
    }
}