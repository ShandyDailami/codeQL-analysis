import java.security.cert.X509Certificate;

public interface CredentialValidator {

    boolean validate(X509Certificate certificate);

}

public class java_07561_CredentialValidator_A03 implements CredentialValidator {

    private String validCertificateThumbprint;

    public java_07561_CredentialValidator_A03(String validCertificateThumbprint) {
        this.validCertificateThumbprint = validCertificateThumbprint;
    }

    @Override
    public boolean validate(X509Certificate certificate) {
        return certificate.getThumbprint().equals(validCertificateThumbprint);
    }
}

public class Main {

    public static void main(String[] args) {
        // Creating a validator with a valid certificate
        CredentialValidator validator = new StandardCredentialValidator("FAKE_CERTIFICATE_THUMBPRINT");

        // This is a placeholder for a real certificate
        X509Certificate certificate = null; 

        // Validate the certificate
        if (validator.validate(certificate)) {
            System.out.println("Certificate is valid.");
        } else {
            System.out.println("Certificate is invalid.");
        }
    }
}