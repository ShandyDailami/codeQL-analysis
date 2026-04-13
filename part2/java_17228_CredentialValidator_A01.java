import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.security.auth.x500.X500Principal;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import sun.security.util.KeyUtil;

public class java_17228_CredentialValidator_A01 implements CallbackHandler {

    private KeyStore keyStore;

    public java_17228_CredentialValidator_A01(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    public Key getKey(String key, String authType) throws UnsupportedCallbackException {
        try {
            return keyStore.getKey(key, new char[] {});
        } catch (Exception e) {
            throw new UnsupportedCallbackException(e);
        }
    }

    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        throw new UnsupportedCallbackException(null, "Unsupported callbacks");
    }
}

public class MyKeyStore implements KeyStore {

    private Key key;

    public java_17228_CredentialValidator_A01(Key key) {
        this.key = key;
    }

    public Key getKey(String key, char[] chars) {
        return key;
    }

    public void load(CallbackHandler callbackHandler, String s) throws Exception {
        throw new Exception("load not supported");
    }

    public String getDefaultAlgorithm() {
        return "MyKeyStore";
    }
}

public class MyCredentialValidator implements javax.security.auth.credential.CredentialValidator {

    public java_17228_CredentialValidator_A01() {
    }

    public KeyStore getKeyStore(String type, char[] chars) throws Exception {
        return new MyKeyStore(KeyUtil.generateKey());
    }

    public String getPassword(char[] chars) throws Exception {
        return "password";
    }

    public void validate(KeyStore keyStore) throws CredentialValidationException {
        throw new CredentialValidationException("Access Denied");
    }
}