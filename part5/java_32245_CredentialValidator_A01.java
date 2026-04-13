import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_32245_CredentialValidator_A01 implements CallbackHandler {

    private final char[] password;
    private final KeyStore keyStore;

    public java_32245_CredentialValidator_A01(char[] password, String keyStoreType, String keyStorePath)
            throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        this.password = password;
        keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(keyStorePath, password);
    }

    @Override
    public String getPassword() {
        return new String(password);
    }

    @Override
    public void handle(Callback[] callbacks)
            throws UnsupportedCallbackException {
        // Not used here, but if callbacks were used, we would handle them
    }
}

public class CustomKeyStoreCallbackHandlerFactory implements CallbackHandlerFactory {

    private final String keyStoreType;
    private final String keyStorePath;
    private final char[] password;

    public java_32245_CredentialValidator_A01(String keyStoreType, String keyStorePath, char[] password) {
        this.keyStoreType = keyStoreType;
        this.keyStorePath = keyStorePath;
        this.password = password;
    }

    @Override
    public CallbackHandler createCallbackHandler() {
        try {
            return new CustomKeyStoreCallbackHandler(password, keyStoreType, keyStorePath);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new RuntimeException(e);
        }
    }
}

// Usage
KeyStore.AlgorithmAndVersion algorithmAndVersion = new KeyStore.AlgorithmAndVersion("PKCS11", KeyStore.Version.Version11);
KeyStore keyStore = KeyStore.getInstance(algorithmAndVersion);

CustomKeyStoreCallbackHandlerFactory callbackHandlerFactory =
        new CustomKeyStoreCallbackHandlerFactory(algorithmAndVersion.getType(), "/path/to/keystore", "password".toCharArray());

keyStore.load(callbackHandlerFactory);