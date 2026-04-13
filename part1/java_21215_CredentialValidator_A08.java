import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_21215_CredentialValidator_A08 implements CredentialValidator {

    private KeyStore keyStore;
    private String keyStoreType = "JKS";
    private String keyStorePassword = "password";
    private String keyPassword = "password";

    public java_21215_CredentialValidator_A08() {
        try {
            keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(getClass().getResourceAsStream("/keystore.jks"), keyStorePassword.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getName() {
        return "CustomCredentialValidator";
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public Key getKey() {
        try {
            return keyStore.getKey("alias", keyPassword.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Certificate[] getCertificates() {
        return new Certificate[0];
    }

    @Override
    public void refresh() {
        // not needed
    }
}