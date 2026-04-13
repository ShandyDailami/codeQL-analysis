import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.CredentialCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import javax.security.auth.message.callback.TextCallback;

public class java_40244_CredentialValidator_A07 implements CallbackHandler, CredentialCallback {

    private KeyStore keyStore;

    public java_40244_CredentialValidator_A07() throws KeyStoreException, CertificateException, NamingException {
        keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("credentials.jks"), "password".toCharArray());
    }

    public Key getKey(String password) throws UnsupportedOperationException {
        return keyStore.getKey("password".toCharArray(), password.toCharArray());
    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken(String username, char[] password) {
        return new UsernamePasswordAuthenticationToken(username, new String(password));
    }

    public void setCallbackHandler(CallbackHandler handler) {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    public CredentialCallback getCredentialCallback() {
        return this;
    }

    public String getPassword(String prompt) throws UnsupportedOperationException {
        return new String();
    }

    public void setCallback(TextCallback callback) throws UnsupportedOperationException {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    public boolean handle(Callback[] callbacks) throws UnsupportedOperationException, CertificateException, AuthenticationException, NamingException {
        return false;
    }

    public boolean getCredentials(String prompt) throws UnsupportedOperationException {
        return false;
    }

    public Key getKey(String password) throws UnsupportedOperationException {
        return keyStore.getKey("password".toCharArray(), password.toCharArray());
    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken(String username, char[] password) {
        return new UsernamePasswordAuthenticationToken(username, new String(password));
    }
}