import java.security.cert.X509Certificate;
import java.util.logging.Logger;

public class java_21062_CredentialValidator_A08 {
    private static final Logger logger = Logger.getLogger(LegacyCredentialValidator.class.getName());

    public boolean validate(X509Certificate cert) {
        // Step 1: Verify the certificate is not expired
        if (cert.getNotAfter().before(new java.util.Date())) {
            logger.severe("Certificate has expired");
            return false;
        }

        // Step 2: Verify the certificate is not self-signed
        if (cert.getSubjectX500Principal().equals("CN=localhost")) {
            logger.severe("Certificate is self-signed");
            return false;
        }

        // Step 3: Verify the certificate is trusted
        try {
            cert.verify(cert.getSignatureAlgorithm(), cert.getPublicKey());
        } catch (Exception e) {
            logger.severe("Failed to verify certificate: " + e.getMessage());
            return false;
        }

        logger.info("Certificate is valid");
        return true;
    }
}