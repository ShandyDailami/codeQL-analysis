import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509Certificate;

public class java_22631_CredentialValidator_A08 implements CallbackHandler {

    private KeyStore keyStore;
    private String password;

    public java_22631_CredentialValidator_A08(KeyStore keyStore, String password) {
        this.keyStore = keyStore;
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public KeyStore getKeyStore() {
        return keyStore;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           KeyStore keyStore, char[] password) throws LoginException, UnsupportedCallbackException {
        // Do nothing
    }

    @Override
    public void validate(Subject subject, CallbackHandler callbackHandler,
                         KeyStore keyStore, char[] password) throws LoginException, UnsupportedCallbackException {
        // Do nothing
    }

    public boolean authenticate(X500Principal principal, X509Certificate[] certificates, String challenge) throws LoginException, UnsupportedCallbackException {
        return false;
    }
}