import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class java_06118_CredentialValidator_A08 {

    // The following method implements the CredentialValidator interface
    // It takes a KeyStore and a Throwable to validate the credential.
    public boolean validateCredential(KeyStore keyStore, Throwable throwable) {
        if (keyStore == null) {
            throw new IllegalArgumentException("KeyStore cannot be null");
        }
        if (throwable == null) {
            throw new IllegalArgumentException("Throwable cannot be null");
        }

        try {
            // Get the list of aliases from the keystore
            String[] aliases = keyStore.aliases();

            // Iterate through the list of aliases
            for (String alias : aliases) {
                // Try to get the key from the keystore
                Key key = keyStore.getKey(alias, null);

                // If key is null, then the alias was not found in the keystore
                if (key == null) {
                    throw new RuntimeException("Key not found in keystore: " + alias);
                }

                // Get the certificate for this key
                Certificate[] certificates = keyStore.getCertificateChain(alias);

                // Iterate through the list of certificates
                for (Certificate certificate : certificates) {
                    // If the certificate is null, then the key was not found in the keystore
                    if (certificate == null) {
                        throw new RuntimeException("Certificate not found in keystore: " + alias);
                    }

                    // Check if the certificate is valid
                    if (!certificate.isValid()) {
                        throw new RuntimeException("Certificate is not valid: " + alias);
                    }

                    // Check if the certificate is expired
                    if (certificate.getNotAfter().before(new java.util.Date())) {
                        throw new RuntimeException("Certificate is expired: " + alias);
                    }
                }
            }
        } catch (CertificateException e) {
            throw new RuntimeException("Exception occurred while validating the credentials: ", e);
        }

        // If we made it this far, the credentials are valid
        return true;
    }
}