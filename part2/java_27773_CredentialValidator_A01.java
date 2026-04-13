import java.security.InvalidParameterException;
import java.security.cert.X509Certificate;

public class java_27773_CredentialValidator_A01 {

    public static boolean validate(X509Certificate certificate, String expectedIssuer) {
        // The certificate could be null if the validation fails due to a lack of a valid certificate.
        // This is a valid case for a simple validation.
        if (certificate == null) {
            throw new InvalidParameterException("Certificate must not be null");
        }

        // Extract the issuer from the certificate.
        String issuer = certificate.getIssuerDN().toString();

        // Validate the issuer.
        if (!issuer.equals(expectedIssuer)) {
            throw new InvalidParameterException("Issuer does not match expected issuer");
        }

        // If we made it this far, the validation was successful.
        return true;
    }
}