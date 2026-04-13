import java.security.cert.X509Certificate;
import java.util.logging.Logger;

public class java_38257_CredentialValidator_A08 {

    private static final Logger logger = Logger.getLogger(CertificateValidator.class.getName());

    public boolean validateCertificate(X509Certificate cert) {
        try {
            cert.checkValidity();
            return true;
        } catch (Exception e) {
            logger.severe("Certificate validation failed. Reason: " + e.getMessage());
            return false;
        }
    }
}