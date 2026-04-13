import java.security.InvalidParameterException;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class java_33244_CredentialValidator_A01 {

    public PublicKey getPublicKeyFromCertificate(Certificate certificate) {
        return certificate.getPublicKey();
    }

    public boolean validateCertificate(PublicKey publicKey, Certificate certificate) {
        return publicKey.equals(certificate.getPublicKey());
    }

    public boolean isCertificateExpired(Certificate certificate) {
        return certificate.getNotAfter().before(new java.util.Date());
    }

    public void validate(PublicKey publicKey, Certificate certificate) throws InvalidParameterException {
        if (!validateCertificate(publicKey, certificate)) {
            throw new InvalidParameterException("Certificate not valid.");
        }

        if (isCertificateExpired(certificate)) {
            throw new InvalidParameterException("Certificate has expired.");
        }
    }
}