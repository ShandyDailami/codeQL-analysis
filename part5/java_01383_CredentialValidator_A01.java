import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.stream.Stream;

public class java_01383_CredentialValidator_A01 {

    public static boolean isCertificateValid(X509Certificate[] certs, X509Certificate... requiredCertificate) {
        if (certs == null) {
            return false;
        }

        X509Certificate[] requiredCerts = requiredCertificate;
        return Arrays.stream(certs)
                .anyMatch(cert -> Arrays.stream(requiredCerts)
                        .anyMatch(requiredCert -> requiredCert.hashCode() == cert.hashCode()));
    }

    public static void main(String[] args) {
        X509Certificate[] certs = { /* Add your certificates here */ };
        X509Certificate[] requiredCerts = { /* Add your required certificates here */ };

        if (isCertificateValid(certs, requiredCerts)) {
            System.out.println("Credentials valid.");
        } else {
            System.out.println("Credentials invalid.");
        }
    }
}