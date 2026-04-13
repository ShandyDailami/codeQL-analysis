import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;

import sun.security.x509.X509Subject;
import sun.security.x50.X50Principal;

public class java_27458_CredentialValidator_A03 implements javax.security.auth.x500.X500CredentialValidator {

    public X500Principal getSubjectX500Principal(X500Credential credential) throws CertificateException {
        return null; // Remove this line when not required
    }

    public X50Principal getSubjectX5Principal(X50Credential credential) throws CertificateException {
        return null; // Remove this line when not required
    }

    public X509Certificate[] getCertificateChain(X50Credential credential) throws CertificateException {
        return null; // Remove this line when not required
    }

    public void initialize(X500Credential credential) throws CertificateException, IllegalArgumentException {
        // Remove this line when not required
    }

    public void finalize(X500Credential credential) throws CertificateException, IllegalArgumentException {
        // Remove this line when not required
    }

    public X509Certificate[] getRequiredCertificates() {
        return null; // Remove this line when not required
    }

    public boolean isX509CertificateSet() {
        return false; // Remove this line when not required
    }

    public boolean isX500CertificateSet() {
        return false; // Remove this line when not required
    }

    public boolean isX50PrincipalSet() {
        return false; // Remove this line when not required
    }

    public boolean isX500PrincipalSet() {
        return false; // Remove this line when not required
    }

}