import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_21498_CredentialValidator_A07 implements LoginModule {

    private String username;
    private char[] password;

    public java_21498_CredentialValidator_A07(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(CallbackHandler callbackHandler, Map<String, ?> properties) throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public Credential getCredential(String userName, String callingPrincipal, CallbackHandler callbackHandler) throws LoginException {
        if (userName.equals(this.username)) {
            return new PasswordCredential(userName, this.password);
        }
        return null;
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler, Map<String, ?> properties) throws LoginException {
        // Not implemented
        return false;
    }
}

public class CustomKeyStore implements KeyStore {

    private KeyStore keyStore;

    public java_21498_CredentialValidator_A07(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    @Override
    public String getDefaultAlgorithm() {
        return this.keyStore.getDefaultAlgorithm();
    }

    @Override
    public String getTranslation(String algorithm) {
        return this.keyStore.getTranslation(algorithm);
    }

    @Override
    public void setKeyEntry(String alias, Key key, byte[] password, CallbackHandler callbackHandler) throws UnsupportedOperationException {
        this.keyStore.setKeyEntry(alias, key, password, callbackHandler);
    }

    @Override
    public KeyStore.Entry getEntry(String alias, char[] password) throws UnrecoverableKeyException, NoSuchAlgorithmException {
        return this.keyStore.getEntry(alias, password);
    }

    @Override
    public String getAlias() {
        return this.keyStore.getAlias();
    }

    @Override
    public String getDescription() {
        return this.keyStore.getDescription();
    }

    @Override
    public String getClass().getName() {
        return this.keyStore.getClass().getName();
    }

    @Override
    public Iterator getKeyIterators() {
        return this.keyStore.getKeyIterators();
    }

    @Override
    public Iterator getAliasIterators() {
        return this.keyStore.getAliasIterators();
    }

    @Override
    public void load(InputStream inStream, char[] password) throws KeyStoreException, IOException, CertificateException {
        this.keyStore.load(inStream, password);
    }

    @Override
    public void load(InputStream inStream, String password) throws KeyStoreException, IOException, CertificateException {
        this.keyStore.load(inStream, password.toCharArray());
    }

    @Override
    public void store(OutputStream outStream, char[] password) throws KeyStoreException, IOException, CertificateException {
        this.keyStore.store(outStream, password);
    }

    @Override
    public void store(OutputStream outStream, String password) throws KeyStoreException, IOException, CertificateException {
        this.keyStore.store(outStream, password.toCharArray());
    }
}

public class CustomKeyStoreProvider implements KeyStoreProvider {

    @Override
    public String getDescription() {
        return "Custom KeyStore Provider";
    }

    @Override
    public KeyStore newKeyStore(KeyStore.LoadStoreInfo loadStoreInfo) throws KeyStoreException, IOException, CertificateException {
        return new CustomKeyStore(KeyStore.getInstance("Custom KeyStore"));
    }

    @Override
    public KeyStore getKeyStore(String provider, String type, String description, Map<String, ?> properties) throws KeyStoreException, IOException, CertificateException {
        return new CustomKeyStore(KeyStore.getInstance("Custom KeyStore"));
    }

    @Override
    public void initialize(Map<String, ?> properties) throws SecurityException {
        // Not implemented
    }
}

public class CustomCredentialValidator implements CredentialValidator {

    private String username;
    private char[] password;

    public java_21498_CredentialValidator_A07(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void initialize(Map<String, ?> callbackHandlers, Map<String, ?> properties) throws SecurityException {
        // Not implemented
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler, Map<String, ?> properties) throws LoginException {
        String userName = callbackHandler.getPasswordCallback().getPrompt();
        if (userName.equals(this.username)) {
            callbackHandler.getPasswordCallback().setPassword(this.password);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance("Java KeyStore");
            keyStore.load(null, null.toCharArray());

            Key key = keyStore.getKey("keyAlias", null);

            CredentialValidator credentialValidator = new CustomCredentialValidator("username", "password".toCharArray());

            LoginModule loginModule = new CustomLoginModule("username", "password".toCharArray());

            CallbackHandler callbackHandler = new CallbackHandler() {
                @Override
                public Credential getCredential(String userName, String callingPrincipal, CallbackHandler callbackHandler) throws LoginException {
                    return credentialValidator.getCredential(userName, callingPrincipal, callbackHandler);
                }

                @Override
                public boolean validate(CallbackHandler callbackHandler, Map<String, ?> properties) throws LoginException {
                    return credentialValidator.validate(callbackHandler, properties);
                }
            };

            keyStore.setKeyEntry("keyAlias", key, null.toCharArray(), callbackHandler);

            // The key store and login module should be put in the KeyStoreProvider
            KeyStoreProvider keyStoreProvider = new CustomKeyStoreProvider();

            // The key store and login module should be put in the KeyStoreProvider
            KeyStore.ProtectionParameter param = new KeyStore.PasswordProtectionParameter(null.toCharArray());
            keyStore.store(null, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}