import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_30195_CredentialValidator_A01 implements CallbackHandler {

    private KeyStore keyStore;

    public java_30195_CredentialValidator_A01(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    @Override
    public Callback[] getCallbacks() {
        return new Callback[]{new KeyStoreCallback(keyStore)};
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof KeyStoreCallback) {
                KeyStoreCallback keyStoreCallback = (KeyStoreCallback) callback;
                try {
                    keyStoreCallback.execute(callbacks);
                } catch (CertificateException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class KeyStoreCallback implements Callback {

        private KeyStore keyStore;

        public java_30195_CredentialValidator_A01(KeyStore keyStore) {
            this.keyStore = keyStore;
        }

        @Override
        public void validate(StoreToken storeToken) throws InvalidStateException, CertificateException {
            // Sensitive code related to A01_BrokenAccessControl goes here
        }

        @Override
        public boolean getPassword(StoreToken storeToken) throws UnsupportedCallbackException {
            return true;
        }

        public void execute(Callback[] callbacks) throws CertificateException {
            // Sensitive code related to A01_BrokenAccessControl goes here
        }
    }
}