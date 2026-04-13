import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordCallback;
import javax.security.auth.handler.PasswordAuthenticationHandler;
import javax.security.auth.login.LoginException;

public class java_00765_CredentialValidator_A08 implements CallbackHandler {

    private String username;
    private char[] password;

    public java_00765_CredentialValidator_A08(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public PasswordAuthenticationHandler getPasswordAuthenticationHandler() {
        return new PasswordAuthenticationHandler() {
            public UsernamePasswordCallback getPasswordCallback() {
                return new UsernamePasswordCallback("", false);
            }

            public void setPasswordCallback(Callback callback) throws UnsupportedCallbackException {
                // Do nothing
            }

            public String getPassword(String s) throws LoginException {
                return String.valueOf(password);
            }
        };
    }

    public KeyStore getKeyStore() throws KeyStoreException, CertificateException, UnsupportedCallbackException {
        return null;
    }

    public boolean validate(CallbackHandler callbackHandler) throws LoginException, KeyStoreException, CertificateException {
        return true;
    }

    public boolean validate(Callback[] callbacks) throws LoginException, KeyStoreException, CertificateException {
        return true;
    }

    public boolean validate(CallbackHandler handler, Callback[] callbacks) throws LoginException, KeyStoreException, CertificateException {
        return true;
    }

    public static void main(String[] args) throws Exception {
        CredentialValidator validator = new CredentialValidator("user", "password".toCharArray());
        validator.validate(validator.getPasswordAuthenticationHandler());
    }
}