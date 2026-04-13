import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.security.auth.login.LoginException;
import sun.security.x509.X509CertImpl;

public class java_08827_CredentialValidator_A08 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws Exception {
        KeyStore keystore = loadKeyStore();
        PrivateKey privateKey = getPrivateKey(keystore);

        X509Certificate certificate = getCertificate(keystore);
        X500Principal subject = certificate.getSubjectX500Principal();

        List<String> subjectAlternateNames = Arrays.asList("CN=John Doe, OU=MyOrg, O=MyOrg, C=US", "CN=Jane Doe, OU=MyOrg, O=MyOrg, C=US");

        if (!validateCredential(privateKey, certificate, subjectAlternateNames)) {
            throw new IllegalStateException("Invalid Credential");
        }
    }

    private static KeyStore loadKeyStore() throws KeyStoreException, CertificateException, NoSuchAlgorithmException {
        return KeyStore.getInstance("JKS");
    }

    private static PrivateKey getPrivateKey(KeyStore keystore) throws KeyStoreException, UnavailableException, NoSuchAlgorithmException {
        return (PrivateKey) keystore.getKey("your_key_alias", "your_key_password".toCharArray());
    }

    private static X509Certificate getCertificate(KeyStore keystore) throws KeyStoreException, CertificateException, UnavailableException {
        return (X509Certificate) keystore.getCertificate("your_certificate_alias");
    }

    private static boolean validateCredential(PrivateKey privateKey, X509Certificate certificate, List<String> subjectAlternateNames) throws LoginException, CertificateException, NoSuchAlgorithmException {
        X509CertImpl certImpl = new X509CertImpl(certificate);

        Certificate[] chain = certImpl.getChain();
        if (chain != null) {
            for (Certificate cert : chain) {
                if (cert instanceof X509CertImpl) {
                    X509CertImpl certImplCert = (X509CertImpl) cert;

                    if (!certImplCert.getSerialNumber().equals(certImpl.getSerialNumber())) {
                        throw new IllegalStateException("Mismatched Serial Numbers");
                    }

                    if (!Arrays.equals(certImplCert.getSubjectX500Principal().getIssuerX500Principal().getName().split(","), certImpl.getSubjectX500Principal().getIssuerX500Principal().getName().split(","))) {
                        throw new IllegalStateException("Mismatched Issuer");
                    }

                    if (!Arrays.equals(certImplCert.getSubjectX500Principal().getName().split(","), certImpl.getSubjectX500Principal().getName().split(","))) {
                        throw new IllegalStateException("Mismatched Subject");
                    }

                    if (!Arrays.equals(certImplCert.getSubjectX500Principal().getSurname().split(","), certImpl.getSubjectX500Principal().getSurname().split(","))) {
                        throw new IllegalStateException("Mismatched Surname");
                    }

                    if (!Arrays.equals(certImplCert.getSubjectX500Principal().getGivenName().split(","), certImpl.getSubjectX500Principal().getGivenName().split(","))) {
                        throw new IllegalStateException("Mismatched Given Name");
                    }

                    if (!certImplCert.getNotAfter().after(certImpl.getNotBefore())) {
                        throw new IllegalStateException("Not After date is incorrect");
                    }

                    if (!certImplCert.getNotBefore().before(certImpl.getNotAfter())) {
                        throw new IllegalStateException("Not Before date is incorrect");
                    }

                    if (!certImplCert.getPublicKey().equals(privateKey)) {
                        throw new IllegalStateException("Public Key does not match");
                    }

                    if (certImplCert.getSubjectAlternativeName() != null) {
                        Enumeration<String> altNames = certImplCert.getSubjectAlternativeName();
                        while (altNames.hasMoreElements()) {
                            String altName = altNames.nextElement();
                            if (!subjectAlternateNames.contains(altName)) {
                                throw new IllegalStateException("Subject Alternative Name does not match");
                            }
                        }
                    }

                    return true;
                }
            }
        }

        return false;
    }
}