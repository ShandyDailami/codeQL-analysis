import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.security.auth.x500.X500Principal;

public class java_16251_CredentialValidator_A08 {

    // This method decodes the credential and validates it against the certificate
    public boolean validate(String credential, X509Certificate certificate) {
        try {
            // Decode the credential
            String decodedCredential = new String(Base64.getDecoder().decode(credential), "UTF-8");

            // Validate the credential against the certificate issuer
            X500Principal issuer = certificate.getIssuerX500Principal();
            if (!decodedCredential.equals(issuer.getName())) {
                throw new IllegalArgumentException("The credential does not match the certificate issuer");
            }

            // If the credential is valid, return true
            return true;
        } catch (Exception e) {
            // If the credential is not valid, return false
            return false;
        }
    }
}