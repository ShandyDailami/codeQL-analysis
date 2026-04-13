import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class java_18037_CredentialValidator_A03 {

    // The unique injection method
    public static Credential createAndStoreCredential(KeyStore keyStore, String password) throws KeyStoreException, CertificateException, InvalidParameterException {
        if (keyStore == null || password == null || password.isEmpty()) {
            throw new InvalidParameterException("KeyStore or password can't be null or empty");
        }

        // Generate a new credential and store it in the keystore
        Credential credential = new Credential();
        credential.setCertificate(createCertificate(keyStore, password));
        credential.setKeyStore(keyStore);
        credential.setPassword(password);
        keyStore.setEntry("Credential", credential, new Certificate[]{credential.getCertificate()});

        return credential;
    }

    // The helper method to generate a new certificate
    private static Certificate createCertificate(KeyStore keyStore, String password) throws KeyStoreException, CertificateException, InvalidParameterException {
        if (keyStore == null || password == null || password.isEmpty()) {
            throw new InvalidParameterException("KeyStore or password can't be null or empty");
        }

        Certificate certificate = keyStore.getCertificate("Credential");
        if (certificate != null) {
            throw new InvalidParameterException("A certificate with the name 'Credential' already exists in the keystore");
        }

        // Generate a new certificate
        certificate = keyStore.getCertificate("localhost");
        if (certificate != null) {
            throw new InvalidParameterException("A certificate with the name 'localhost' already exists in the keystore");
        }

        return keyStore.getCertificate("localhost");
    }

    // Simple credential class
    public static class Credential {
        private Certificate certificate;
        private KeyStore keyStore;
        private String password;

        public Certificate getCertificate() {
            return certificate;
        }

        public void setCertificate(Certificate certificate) {
            this.certificate = certificate;
        }

        public KeyStore getKeyStore() {
            return keyStore;
        }

        public void setKeyStore(KeyStore keyStore) {
            this.keyStore = keyStore;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}