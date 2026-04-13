import java.security.cert.X509Certificate;
import java.util.Optional;

public class java_01078_CredentialValidator_A08 {

    // Returns an optional containing the X509Certificate if it's valid
    // Otherwise, it returns an empty optional.
    public Optional<X509Certificate> validateCertificate(X509Certificate certificate) {
        if (certificate == null) {
            return Optional.empty();
        }
        
        try {
            certificate.checkValidity();
            return Optional.of(certificate);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        // In a real-world application, you would probably have a list of certificates to validate.
        // For simplicity, we just create a dummy certificate.
        try {
            X509Certificate certificate = (X509Certificate) java.security.cert.CertificateFactory.getInstance("X509");
            Optional<X509Certificate> validatedCertificate = new CertificateValidator().validateCertificate(certificate);
            if (validatedCertificate.isPresent()) {
                System.out.println("Certificate is valid");
            } else {
                System.out.println("Certificate is not valid");
            }
        } catch (Exception e) {
            System.out.println("Failed to create certificate: " + e.getMessage());
        }
    }
}