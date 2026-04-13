import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509Spi;
import javax.security.auth.x509.X509CertificateImpl;

public class java_32933_CredentialValidator_A03 extends X509Spi {

    public java_32933_CredentialValidator_A03() {
        super();
    }

    @Override
    public X509Certificate[] validate(X509Certificate certificate) {
        X509Certificate[] certificates = super.validate(certificate);
        return certificates;
    }

    @Override
    public X500Principal getX500Principal(X509Certificate cert) {
        X500Principal principal = super.getX500Principal(cert);
        return principal;
    }
}

class CredentialValidator {
    public static void main(String[] args) {
        // Creating a custom X509Spi
        CustomX509Spi customX509Spi = new CustomX509Spi();
        System.setProperty("javax.security.auth.x500.X500Principal", "CN=CustomX509Spi, OU=CustomX509Spi, O=CustomX509Spi, C=US");
        System.setProperty("javax.security.auth.x509.X509Certificate", "customCertificate");
        System.setProperty("javax.net.ssl.trustStore", "trustStore");
        System.setProperty("javax.net.ssl.trustStorePassword", "trustStorePassword");

        // Validating the certificate
        X509Certificate[] certificates = customX509Spi.validate(null);
        for (X509Certificate certificate : certificates) {
            System.out.println(customX509Spi.getX500Principal(certificate));
        }
    }
}