import java.security.InvalidParameterException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class java_13642_CredentialValidator_A07 {

    // Custom Credential Validator
    public boolean validate(X509Certificate cert) {
        try {
            // Check if the certificate is not null
            if (cert == null) {
                throw new InvalidParameterException("Certificate cannot be null");
            }

            // Check if the certificate is self-signed
            if (cert.isSelfSigned()) {
                System.out.println("Certificate is self-signed");
                return false;
            }

            // Check if the certificate is expired
            if (cert.getNotAfter().before(new java.util.Date())) {
                System.out.println("Certificate is expired");
                return false;
            }

            // If all checks passed, return true
            return true;

        } catch (CertificateException e) {
            System.out.println("Certificate validation failed: " + e.getMessage());
            return false;
        }
    }
}