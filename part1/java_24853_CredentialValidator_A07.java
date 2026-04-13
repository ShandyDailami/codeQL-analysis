import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509CertificateImpl;
import org.bouncycastle.util.io.pem.PemReader;

import sun.security.pkcs11.PKCS11;
import sun.security.pkcs11.PKCS11Exception;
import sun.security.util.SecurityUtils;

public class java_24853_CredentialValidator_A07 {

    public static void main(String[] args) {
        try {
            validate("src/main/resources/myCert.pem", "src/main/resources/private.key");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validate(String certFilePath, String keyFilePath) throws GeneralSecurityException, PKCS11Exception {
        X509Certificate certificate = loadCertificate(certFilePath);
        Key key = loadPrivateKey(keyFilePath);

        certificate.verify(key);
    }

    private static X509Certificate loadCertificate(String certFilePath) throws GeneralSecurityException {
        X509CertificateHolder holder = new X509CertificateHolder(certFilePath);
        X509Certificate cert = new X509CertificateImpl(holder);
        return cert;
    }

    private static Key loadPrivateKey(String keyFilePath) throws GeneralSecurityException, NoSuchAlgorithmException {
        PrivateKey key;

        try {
            key = SecurityUtils.loadPrivateKey(keyFilePath, "RSA", "NONE");
        } catch (Exception e) {
            key = SecurityUtils.loadPrivateKey(keyFilePath, "DSA", "NONE");
        }

        return key;
    }
}