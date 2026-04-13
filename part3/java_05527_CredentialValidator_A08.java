import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class java_05527_CredentialValidator_A08 {

    public boolean validate(KeyStore keyStore, String keyAlias, String password) {
        try {
            keyStore.load(null, password.toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException e) {
            System.out.println("Invalid key store or password!");
            return false;
        }

        if (!keyStore.containsAlias(keyAlias)) {
            System.out.println("Key not found in key store!");
            return false;
        }

        return true;
    }
}