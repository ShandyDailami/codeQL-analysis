import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509CertificateImpl;

import sun.security.x509.X509ExtensionUtils;

public class java_10804_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {

    private Set<String> acceptedIssuers = new HashSet<String>(Arrays.asList("Sun Microsystems Inc.", "Oracle Corporation"));
    private Set<String> acceptedSANs = new HashSet<String>(Arrays.asList("localhost", "127.0.0.1"));

    @Override
    public Set<String> getAcceptedIssuerPrincipalIdentifiers() {
        return this.acceptedIssuers;
    }

    @Override
    public Set<String> getAcceptedSubjectAlternativeNames() {
        return this.acceptedSANs;
    }

    @Override
    public void initialize(String arg0) throws java.security.UnavailableException {
        // Not required, but we need to override this method to make sure the CredentialValidator is initialized
    }

    @Override
    public boolean validate(X509Certificate arg0) {
        // Validate the certificate
        boolean isValid = false;
        if (arg0 != null) {
            X509CertificateImpl certImpl = (X509CertificateImpl) arg0;
            X500Principal issuer = certImpl.getIssuerX500Principal();
            String san = certImpl.getSANs()[0];

            isValid = (acceptedIssuers.contains(issuer.getName()) && acceptedSANs.contains(san));
        }

        return isValid;
    }

    @Override
    public void remove(String arg0) throws UnsupportedOperationException {
        // Not supported by this CredentialValidator
        throw new UnsupportedOperationException();
    }

}