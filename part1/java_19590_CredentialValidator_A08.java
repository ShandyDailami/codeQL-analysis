import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.security.auth.x500.X500Principal;

import sun.security.pkcs11.PKCS11;
import sun.security.pkcs11.PKCS11Exception;

public class java_19590_CredentialValidator_A08 {

    public boolean validate(String keystorePath, String keystorePassword, String alias, String password) {
        try {
            KeyStore keystore = loadKeyStore(keystorePath, keystorePassword);
            Key key = getKey(keystore, alias, password);
            return key != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private Key getKey(KeyStore keystore, String alias, String password) throws UnsupportedOperationException, KeyStoreException, CertificateException, IOException, PKCS11Exception {
        return keystore.getKey(alias, password.toCharArray());
    }

    private KeyStore loadKeyStore(String keystorePath, String keystorePassword) throws KeyStoreException, IOException, CertificateException {
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        keystore.load(new FileInputStream(keystorePath), keystorePassword.toCharArray());
        return keystore;
    }
}