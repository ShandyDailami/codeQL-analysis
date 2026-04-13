import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_12138_CredentialValidator_A01 implements CredentialValidator {

    private KeyStore keyStore;

    public java_12138_CredentialValidator_A01(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    @Override
    public boolean validate(Credential credential) {
        try {
            // Extract the certificate from the credential
            Certificate certificate = credential.getCertificate();
            // Check if the certificate is valid
            certificate.checkValidity();
            // Verify the certificate with the key store
            keyStore.getCertificateChain(certificate);
            // If everything is fine, return true
            return true;
        } catch (GeneralSecurityException e) {
            // If there's an issue, return false
            return false;
        }
    }
}