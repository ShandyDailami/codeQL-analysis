import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

public class java_16598_CredentialValidator_A01 {

    // List of trusted certificates
    private static final List<X509Certificate> TRUSTED_CERTS = Arrays.asList(
            // Add trusted certificates here.
            // You can also use a Certificate Authority (CA) for testing.
            // An example of trusted certificate can be loaded from a file
            // truststore.pkcs12("/path/to/truststore.p12", "truststorepassword".toCharArray())
    );

    public static void validate(X509Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate cannot be null.");
        }

        // Check if the certificate is trusted
        if (!isTrusted(certificate)) {
            throw new SecurityException("Certificate is not trusted.");
        }

        // Perform other security-sensitive operations here.
        // For instance, check if the certificate has the correct expiry date
        if (!isValid(certificate)) {
            throw new SecurityException("Certificate is expired or invalid.");
        }
    }

    private static boolean isTrusted(X509Certificate certificate) {
        // Implement a check to see if the certificate is trusted
        // This could involve checking the certificate against a list of trusted certificates
        return TRUSTED_CERTS.contains(certificate);
    }

    private static boolean isValid(X509Certificate certificate) {
        // Implement a check to see if the certificate is valid
        // This could involve checking the certificate against the current date
        return certificate.getNotAfter().after(System.currentTimeMillis());
    }
}