import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_39684_CredentialValidator_A08 implements CallbackHandler {

    @Override
    public java.security.Authentication getAuthentication(CallbackHandler handler) throws UnsupportedCallbackException {
        return getAuthentication();
    }

    @Override
    public java.security.Authentication getAuthentication() {
        return null;
    }

    public static class CustomKeyStore implements KeyStore {

        private Key key;

        public java_39684_CredentialValidator_A08(Key key) {
            this.key = key;
        }

        @Override
        public Key getKey(String keyAlias, char[] keyPassword) throws UnsupportedOperationException {
            return this.key;
        }

        @Override
        public String getDefaultAlgorithm() {
            return "CustomKeyStore";
        }

        @Override
        public void store(InputStream keyStoreContent, char[] keyPassword) throws KeyStoreException, IOException, CertificateException {
            // Do nothing - we only store the key here
        }

        @Override
        public String getAlias() {
            return "CustomKeyStore";
        }

        @Override
        public String getPassword(char[] chars) throws UnsupportedOperationException {
            return new String(chars);
        }

        @Override
        public void load(InputStream keyStoreContent, char[] keyPassword) throws KeyStoreException, IOException, CertificateException {
            // Do nothing - we only load the key here
        }

        @Override
        public boolean isKeyEntitled(String keyAlias) throws NoSuchAlgorithmException {
            return true;
        }

        @Override
        public KeyStore.Entry getEntry(String keyAlias, char[] keyPassword) throws UnsupportedOperationException {
            return new KeyStore.Entry(keyAlias, keyPassword);
        }

        @Override
        public void setEntry(String keyAlias, KeyStore.Entry newEntry) throws UnsupportedOperationException {
            // Do nothing - we only set the key here
        }

        @Override
        public Iterator getAliasIterator() {
            // Not applicable here
            return null;
        }

        @Override
        public void deleteEntry(String keyAlias) throws UnsupportedOperationException {
            // Do nothing - we only delete the key here
        }

        @Override
        public void store(OutputStream keyStoreContent, char[] keyPassword) throws KeyStoreException, IOException, CertificateException {
            // Do nothing - we only store the key here
        }
    }

    public class CustomKeyManager implements KeyManager {

        private Key key;

        public java_39684_CredentialValidator_A08(Key key) {
            this.key = key;
        }

        @Override
        public Key getKey(String keyAlias, char[] keyPassword) {
            return this.key;
        }

        @Override
        public String getDefaultAlgorithm() {
            return "CustomKeyManager";
        }

        @Override
        public void store(OutputStream keyStoreContent, char[] keyPassword) throws IOException, KeyStoreException {
            // Do nothing - we only store the key here
        }
    }

    public class CustomCallbackHandler implements CallbackHandler {

        @Override
        public java.security.Authentication getAuthentication(CallbackHandler handler) throws UnsupportedCallbackException {
            return null;
        }

        @Override
        public java.security.Authentication getAuthentication() {
            return null;
        }
    }
}