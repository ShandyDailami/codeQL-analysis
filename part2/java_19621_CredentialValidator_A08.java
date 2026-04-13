import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509CertificateImpl;

import sun.security.x509.X509Subject;

public class java_19621_CredentialValidator_A08 {

    public boolean validate(String userId, String password, X509Certificate clientCertificate) {
        // Step 1: Decode the Base64 password
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Step 2: Extract the subject from the certificate
        X509CertificateImpl certificateImpl = (X509CertificateImpl) clientCertificate;
        X509Certificate certificate = certificateImpl.getCertificate();
        X500Principal subjectDN = certificate.getSubjectX500Principal();

        // Step 3: Check if the subject is equal to the user ID
        String subjectId = subjectDN.getName();

        // Step 4: Compare the decoded password with the subject ID
        if (subjectId.equals(userId) && subjectId.equals(new String(decodedPassword))) {
            return true;
        } else {
            return false;
        }
    }
}