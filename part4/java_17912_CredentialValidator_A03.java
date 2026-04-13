import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.handler.CallbackHandler;
import javax.security.auth.handler.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.store.CredentialStore;
import javax.security.auth.store.CredentialStoreException;

public class java_17912_CredentialValidator_A03 implements CredentialStore {

    private String username;
    private char[] password;

    public java_17912_CredentialValidator_A03(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Credential retrieve(CallbackHandler callbackHandler)
            throws CredentialStoreException, UnsupportedCallbackException, LoginException {
        return new UsernamePasswordCredential(username, new String(password));
    }

    @Override
    public void store(Credential c, CallbackHandler callbackHandler)
            throws CredentialStoreException, UnsupportedCallbackException, LoginException {
        // Do nothing
    }

    @Override
    public void remove(Credential c, CallbackHandler callbackHandler)
            throws CredentialStoreException, UnsupportedCallbackException, LoginException {
        // Do nothing
    }

    @Override
    public void startEngine(CallbackHandler callbackHandler) throws UnsupportedCallbackException, LoginException {
        // Do nothing
    }

    @Override
    public void stopEngine(CallbackHandler callbackHandler) throws UnsupportedCallbackException, LoginException {
        // Do nothing
    }

    @Override
    public void close() throws CredentialStoreException {
        // Do nothing
    }

    @Override
    public boolean supportsStore(Class<?> arg0) {
        return false;
    }

    @Override
    public boolean supportsRetrieve(Class<?> arg0) {
        return false;
    }

    @Override
    public boolean supportsDelete(Class<?> arg0) {
        return false;
    }

    @Override
    public boolean supportsUpdate(Class<?> arg0) {
        return false;
    }

    @Override
    public boolean supportsCredential(Class<?> arg0) {
        return false;
    }

}