import java.security.cert.X509Certificate;
import java.util.Base64;

public class java_05883_CredentialValidator_A08 {

    // This method will be used to check the integrity of a credential
    public boolean validateCredential(String credential) {

        // Decode the credential from base64
        byte[] decodedCredential = Base64.getDecoder().decode(credential);

        // Parse the certificate from the decoded credential
        X509Certificate certificate = (X509Certificate) java.security.cert.CertificateFactory.getInstance("X509");
        certificate.generateCertificate(decodedCredential);

        // Verify the credential integrity
        if (certificate.getPublicKey().getAlgorithm().equals("SHA1withRSA")) {
            return true;
        } else {
            return false;
        }
    }
}