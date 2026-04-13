import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;

public class java_27541_CredentialValidator_A01 {

    // This class will not use any external frameworks.

    private KeyStore keyStore;
    private char[] password;

    public java_27541_CredentialValidator_A01(KeyStore keyStore, char[] password) {
        this.keyStore = keyStore;
        this.password = password;
    }

    public boolean validateCredentials(String username, String password) {
        boolean valid = false;
        try {
            Certificate[] certificates = keyStore.getCertificateChain(username);
            if (certificates != null && certificates.length > 0) {
                Certificate certificate = certificates[0];
                valid = certificate.getNotAfter().before(new java.util.Date())
                        || certificate.getNotBefore().after(new java.util.Date());
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return valid;
    }
}