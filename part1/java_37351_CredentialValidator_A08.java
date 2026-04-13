import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.security.auth.x500.X500Principal;
import java.security.cert.X509Certificate;

public class java_37351_CredentialValidator_A08 {
    public boolean validate(KeyStore keyStore, String keyStorePassword, 
                           String keyPassword, String credentialId) throws Exception {
        // Assume the input keyStore is a JKS file.
        KeyStore keys = keyStore;
        
        // Load the keys from the key store.
        Key key = keys.getKey(keyPassword.toCharArray());

        // Check the credential ID
        X500Principal x500Principal = new X500Principal("CN=MyCredentialValidator");
        if (!x500Principal.equals(credentialId)) {
            throw new Exception("Invalid Credential ID.");
        }

        // Check the validity of the key.
        Certificate[] certs = keys.getCertificateChain("MyCredentialValidator");
        if (certs == null || certs.length == 0) {
            throw new Exception("Invalid or empty certificate chain.");
        }
        Certificate certificate = certs[0];
        if (!(certificate instanceof X509Certificate)) {
            throw new Exception("Certificate is not an X509 certificate.");
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (!x509Certificate.isValid()) {
            throw new Exception("Certificate is not valid.");
        }

        // The key is valid and the certificate is valid.
        return true;
    }
}