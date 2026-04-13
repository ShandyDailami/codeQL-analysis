import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509CertificateImpl;

public class java_20248_CredentialValidator_A03 {

    // This list of allowed domains
    private static final List<String> ALLOWED_DOMAINS = Arrays.asList("example1.com", "example2.com");

    public boolean isValidDomain(String domain) {
        if (ALLOWED_DOMAINS.contains(domain)) {
            return true;
        }
        return false;
    }

    public boolean isValidCertificate(X509Certificate cert) {
        try {
            X500Principal x500Principal = new X500Principal(cert.getSubjectX500Principal());
            X500Principal issuer = new X500Principal(cert.getIssuerX500Principal());
            if (isValidDomain(x500Principal.getUniqueID()) && isValidDomain(issuer.getUniqueID())) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isValid(X509Certificate[] certificates, String authenticationAuthority) {
        if (certificates != null) {
            for (X509Certificate certificate : certificates) {
                if (isValidCertificate(certificate)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValid(X509Certificate certificate, String authenticationAuthority) {
        if (certificate != null) {
            return isValidCertificate(certificate);
        }
        return false;
    }
}