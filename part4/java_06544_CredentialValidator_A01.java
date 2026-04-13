import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class java_06544_CredentialValidator_A01 {

    private KeyStore keyStore;

    public java_06544_CredentialValidator_A01() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(SecureCredentialValidator.class.getResourceAsStream("/credentials.jks"), "password".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new IllegalStateException("Failed to initialize KeyStore", e);
        }
    }

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password cannot be null");
        }

        try {
            keyStore.getKey(username.toCharArray(), "password".toCharArray());
        } catch (UnrecoverableKeyException | NoSuchAlgorithmException | InvalidParameterException | KeyStoreException e) {
            return false;
        }

        return true;
    }
}