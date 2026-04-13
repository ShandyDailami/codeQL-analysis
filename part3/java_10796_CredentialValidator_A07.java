import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_10796_CredentialValidator_A07 implements CallbackHandler {

    private KeyStore keyStore;

    public java_10796_CredentialValidator_A07(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    @Override
    public java.security.auth.callback.Callback[] handle(java.security.auth.callback.Callback[] callbacks)
            throws java.security.auth.AuthenticationException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            callbacks[i] = new CertificateCallback(keyStore, callbacks[i]);
        }
        return callbacks;
    }

    private static class CertificateCallback implements Callback {

        private final Certificate[] certificates;
        private final Callback handler;

        CertificateCallback(KeyStore keystore, Callback handler) {
            this.handler = handler;
            this.certificates = keystore.getCertificateChain("alias");
        }

        @Override
        public void passwordCallback(char[] chars) {
            // Do nothing
        }

        @Override
        public void passwordCallback(String s) {
            // Do nothing
        }

        @Override
        public boolean getPassword(String s) {
            return false;
        }

        @Override
        public void clearPassword() {}

        @Override
        public Certificate[] getCertificateChain(String alias) {
            return certificates;
        }

        @Override
        public String getAcctAlias() {
            // Return an alias or null if none is set
            return null;
        }

        @Override
        public String getAcctPassword() {
            // Return a password or null if none is set
            return null;
        }

        @Override
        public void initialize(String arg0, String arg1) {}
    }
}