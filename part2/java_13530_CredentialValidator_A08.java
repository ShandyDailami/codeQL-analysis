import java.security.cert.X509Certificate;
import java.util.Iterator;

public class java_13530_CredentialValidator_A08 implements CredentialValidator {
    private X509Certificate certificate;

    public java_13530_CredentialValidator_A08(X509Certificate certificate) {
        this.certificate = certificate;
    }

    @Override
    public void validate(Iterator<? super X509Certificate> certStore) {
        // Check if cert is self-signed or not from certificate store
        if (certificate == null || !certificate.isSelfSigned()) {
            throw new SecurityException("Certificate is either self-signed or not available in the certificate store");
        }

        // Check if cert is expired or not
        if (certificate.getNotAfter().before(new java.util.Date())) {
            throw new SecurityException("Certificate is either expired or not available in the certificate store");
        }

        // Check if cert is revoked or not
        if (certificate.getRevocationStatus() == null) {
            throw new SecurityException("Certificate is either revoked or not available in the certificate store");
        }
    }
}