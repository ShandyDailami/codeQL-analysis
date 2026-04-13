import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class java_30818_CredentialValidator_A08 {
    private static final String KEYSTORE_PATH = "credentials.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String CERTIFICATE_ALIAS = "credential";

    public static void main(String[] args) {
        try {
            KeyStore keystore = loadKeyStore();
            Key key = getKey(keystore);
            validate(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static KeyStore loadKeyStore() throws Exception {
        return KeyStore.getInstance("JKS");
    }

    private static Key getKey(KeyStore keystore) throws Exception {
        return keystore.getKey(CERTIFICATE_ALIAS, KEYSTORE_PASSWORD.toCharArray());
    }

    private static void validate(Key key) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
        Certificate certificate = certificateFactory.generateCertificate(key.getEncoded());
        X509Certificate x509Certificate = (X509Certificate) certificate;
        System.out.println("Certificate: " + x509Certificate.toString());
        System.out.println("Issuer: " + x509Certificate.getIssuerDN());
        System.out.println("Subject: " + x509Certificate.getSubjectDN());
        System.out.println("Serial Number: " + x509Certificate.getSerialNumber());
        System.out.println("Not before: " + x509Certificate.getNotBefore());
        System.out.println("Not after: " + x509Certificate.getNotAfter());
        System.out.println("Signature algorithm: " + x509Certificate.getSigAlgName());
        System.out.println("Hash algorithm: " + x509Certificate.hashAlgName);
    }
}