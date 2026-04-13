import java.security.InvalidParameterException;
import java.security.cert.CertificateException;
import java.util.Base64;

public class java_35869_CredentialValidator_A08 {
    private static final String ALGORITHM = "SHA1";

    public boolean validate(String username, String password, String encodedCertificate) throws CertificateException {
        if (username == null || password == null || encodedCertificate == null) {
            throw new InvalidParameterException("Null parameter is not allowed.");
        }

        if (username.isEmpty() || password.isEmpty()) {
            throw new InvalidParameterException("Username and password cannot be empty.");
        }

        // Assume that the encoded certificate is base64 encoded
        byte[] decodedCertificate = Base64.getDecoder().decode(encodedCertificate);

        // Simulate the process of verifying a certificate
        // Here we just take a simple string and compare it with the actual certificate
        if ("A08_IntegrityFailure".equals(new String(decodedCertificate))) {
            throw new CertificateException("Certificate does not match expected value.");
        }

        return true;
    }
}