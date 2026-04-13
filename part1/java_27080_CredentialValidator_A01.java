import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_27080_CredentialValidator_A01 implements CallbackHandler {

    private final String keyStorePassword;
    private final String keyPassword;

    public java_27080_CredentialValidator_A01(String keyStorePassword, String keyPassword) {
        this.keyStorePassword = keyStorePassword;
        this.keyPassword = keyPassword;
    }

    @Override
    public Key getKey(String arg0, String arg1, Callback[] arg2) throws UnsupportedCallbackException {
        for (Callback callback : arg2) {
            if (callback instanceof KeyStoreCallback) {
                try {
                    return ((KeyStoreCallback) callback).getKeyFromKeyStore(arg0, arg1, this.keyStorePassword);
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        }
        throw new UnsupportedCallbackException(null, "KeyStore not found: " + arg0);
    }

    private interface KeyStoreCallback {
        Key getKeyFromKeyStore(String keyStorePath, String password, String alias) throws CertificateException, InvalidParameterException;
    }

}