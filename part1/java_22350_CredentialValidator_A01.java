import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;

public class java_22350_CredentialValidator_A01 {

    public boolean validateCertificate(Certificate certificate, String password) {
        try {
            certificate.checkValidity();
            return true;
        } catch (CertificateExpiredException | CertificateNotYetValidException e) {
            System.out.println("Certificate is not valid for this password");
            return false;
        } catch (CertificateException e) {
            System.out.println("Failed to process certificate: " + e.getMessage());
            return false;
        }
    }

    public boolean validateCertificate(Certificate certificate, String password, String expectedIssuer) {
        try {
            if (!certificate.getIssuer().equals(expectedIssuer)) {
                System.out.println("Issuer of the certificate does not match expected issuer");
                return false;
            }

            if (certificate.checkValidity()) {
                return true;
            } else {
                System.out.println("Certificate is not valid for this password");
                return false;
            }
        } catch (CertificateException e) {
            System.out.println("Failed to process certificate: " + e.getMessage());
            return false;
        }
    }

}