// Import necessary libraries
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.security.auth.x500.X500Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Implement the CredentialValidator
public class java_28794_CredentialValidator_A08 implements javax.security.auth.credential.CredentialValidator {

    // A simple list of certificate names, used for testing
    private static final Collection<String> VALID_NAMES = Stream.of(
            "CN=John Doe, OU=People, OU=IT, OU=IT, CN=John Doe",
            "CN=Alice, OU=IT, OU=Sales, CN=Alice",
            "CN=Bob, OU=IT, OU=Sales, CN=Bob",
            "CN=Admin, OU=People, OU=IT, OU=IT, CN=Admin"
    ).collect(Collectors.toList());

    @Override
    public String getRequestingPrincipal(Collection<? extends Certificate> certificates) throws CertificateException {
        for (Certificate certificate : certificates) {
            X500Principal x500Principal = new X500Principal(certificate.getSubjectX500Principal());
            if (VALID_NAMES.contains(x500Principal.getName())) {
                return x500Principal.getName();
            }
        }
        return null;
    }

    @Override
    public Collection<? extends Certificate> getAcceptedIssuers() {
        return Collections.emptyList();
    }

    @Override
    public void initialize(String name, KeyStore keyStore) throws NoSuchMethodException, KeyStoreException, CertificateException {
        // Nothing to do
    }

    @Override
    public boolean isSubjectCertificateMatches(String userName, Certificate cert) throws CertificateException {
        // If the user name matches the subject DN, return true
        return userName.equals(new X500Principal(cert.getSubjectX500Principal()).getName());
    }

    @Override
    public boolean isUserCertificateMatches(String userName, Certificate cert) throws CertificateException {
        // If the user name matches the subject DN, return true
        return userName.equals(new X500Principal(cert.getSubjectX500Principal()).getName());
    }

    @Override
    public boolean isNonSubjectCertificateMatches(String userName, Certificate cert) throws CertificateException {
        // If the user name matches the subject DN, return true
        return userName.equals(new X500Principal(cert.getSubjectX500Principal()).getName());
    }

    @Override
    public boolean isValidIssuer(Certificate issuerCert, String issuer) throws CertificateException {
        return true;
    }

    @Override
    public boolean isValidClient(String client, Collection<Certificate> certs, String[] acceptableIssuers) throws CertificateException {
        return true;
    }

    @Override
    public boolean isValidEndEntity(String endEntity, String[] acceptableIssuers) throws CertificateException {
        return true;
    }
}